package p.database.Operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import p.database.Annotations.Getter;
import p.database.DatabaseConnection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InsertConcrete<T> {

    final JdbcTemplate jdbcTemplate;
    final DatabaseConnection databaseConnection;

    @Autowired
    public InsertConcrete(){
        jdbcTemplate = new JdbcTemplate();
        databaseConnection = new DatabaseConnection();

        jdbcTemplate.setDataSource(databaseConnection.connection());
    }

    public void insert(String tableName, List<String> listOfColumns, T object, Class<T> theClass){

        String sqlQuery = String.format("INSERT INTO %s(",tableName);

        StringBuilder stringBuilder = new StringBuilder(sqlQuery);

        Method[] methods = object.getClass().getMethods();
        List<Method> getters = Arrays.stream(methods).filter(element ->{

            if (element.isAnnotationPresent(Getter.class)) return true;
            return false;
        })
                .sorted(Comparator.comparing(Method::getName))
                .collect(Collectors.toList());

        listOfColumns.forEach(element ->{
            stringBuilder.append(element + ',');
        });

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append(") VALUES(");

        Object finalObj = object;
        getters.forEach(element ->{
            try {
                element.setAccessible(true);
                System.out.println(element.getName().toString());
                stringBuilder.append("'" + element.invoke(finalObj,null).toString() + "'" +  ',');
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append(")");

        String finalSqlQuery = stringBuilder.toString();
        System.out.println(finalSqlQuery);  //DEBUG
        jdbcTemplate.update(finalSqlQuery);

    }
}
