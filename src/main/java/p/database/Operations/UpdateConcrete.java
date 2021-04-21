package p.database.Operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import p.database.Annotations.Getter;
import p.database.Annotations.Setter;
import p.database.DatabaseConnection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UpdateConcrete<T> {

    final JdbcTemplate jdbcTemplate;
    final DatabaseConnection databaseConnection;

    @Autowired
    public UpdateConcrete(){
        jdbcTemplate = new JdbcTemplate();
        databaseConnection = new DatabaseConnection();

        jdbcTemplate.setDataSource(databaseConnection.connection());
    }

    public List<String> whatColumnsNeedToBeModified(List<String>listOfColumns){
        Scanner getCommandFromUser = new Scanner(System.in);
        System.out.println("What columns need to be updated ? [id, name, etc...] ");
        System.out.println("[example-input]: id,name,  hall_rows");
        String[] _columnsToBeParsed = getCommandFromUser.nextLine().strip().split(",");

        List<String> columnsToBeParsed = new ArrayList<>(Arrays.asList(_columnsToBeParsed));
        columnsToBeParsed.stream()
                .filter(element ->{
            if (listOfColumns.contains(element)) return true;
            return false;
        })
                .distinct()
                .sorted(Comparator.comparing(Objects::toString))
                .collect(Collectors.toList());

        return columnsToBeParsed;
    }

    public void update(String tableName, String possibleWhereStatement, List<String> listOfColumns, T object, Class<T> theClass){

        List<String> modifiers = whatColumnsNeedToBeModified(listOfColumns)
                .stream()
                .map(String::toLowerCase)
                .map(String::strip)
                .sorted(Comparator.comparing(Object::toString))
                .collect(Collectors.toList());

        System.out.println(modifiers);

        String sqlQuery = String.format("UPDATE %s SET",tableName);
        StringBuilder stringBuilder = new StringBuilder(sqlQuery);

        for(var modifier : modifiers){
            stringBuilder.append(" " + modifier + " =" + " '%s',");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        Scanner scanner = new Scanner(System.in);
        System.out.print(possibleWhereStatement +  " of entry to be changed -> ");
        String possibleWhereStatementId = scanner.nextLine();

        stringBuilder.append(" WHERE " + possibleWhereStatement + " = " + possibleWhereStatementId + ", ");

        Method[] _getters = object.getClass().getMethods();

        List<Method> getters = Arrays.stream(_getters)
                .filter(element ->{
                    if (element.isAnnotationPresent(Getter.class)) return true;
                    return false;
                })
                .filter(element ->{
                    if(modifiers.contains(element.getName().split("get")[1].toLowerCase(Locale.ROOT))){
                        return true;
                    }
                    return false;
                })
                .distinct()
                .sorted(Comparator.comparing(Object::toString))
                .collect(Collectors.toList());

        List<Method> setters = Arrays.stream(_getters)
                .filter(element ->{
                    if (element.isAnnotationPresent(Setter.class)) return true;
                    return false;
                })
                .filter(element ->{
                    if(modifiers.contains(element.getName().split("set")[1].toLowerCase(Locale.ROOT))){
                        return true;
                    }
                    return false;
                })
                .distinct()
                .sorted(Comparator.comparing(Object::toString))
                .collect(Collectors.toList());

        Object finalObj = object;

        System.out.println("SIZE " + setters.size());
        setters.forEach(element ->{
                    System.out.println("[SETTER] " + element);
                });

                setters.forEach(setter ->{
                    setter.setAccessible(true);
                    System.out.println("[SETTER] " + setter.getName());
                    Scanner scanner_2 = new Scanner(System.in);
                    String name = scanner_2.nextLine();
                    try {
                        setter.invoke(finalObj,name);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        String finalString = stringBuilder.toString();

        for (Method getter : getters) {
            getter.setAccessible(true);
            try{
                finalString = finalString.replaceFirst("%s", (String) getter.invoke(finalObj,null));
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        jdbcTemplate.update(finalString);

    }
}

