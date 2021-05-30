package p.database.Operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import p.database.DatabaseConnection;


import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@Service
public class SelectConcrete<T> {

    private final JdbcTemplate jdbcTemplate;
    private final DatabaseConnection databaseConnection;

    @Autowired
    public SelectConcrete(DatabaseConnection databaseConnection){
        this.jdbcTemplate = new JdbcTemplate();
        this.databaseConnection = databaseConnection;

        jdbcTemplate.setDataSource(databaseConnection.connection());
    }

    public <T> void showOutput(List<T> collection){
        collection.forEach(element ->{
            System.out.println(element);
        });
    }


    public <T>  T select(String tableName, String possibleWhereStatement, Class<T> theClass){
        if(!possibleWhereStatement.equals("")){  // SELECT * FROM TABLE WHERE {ID,NAME,ETC} == ...

            String sqlQuery = String.format("SELECT * FROM %s WHERE %s=?", tableName, possibleWhereStatement);
            Scanner getPossibleGetterFromUser = new Scanner(System.in);
            System.out.println("[example-help] input the id number or name string etc -> ");
            String identify = getPossibleGetterFromUser.nextLine();

            T elementToBeFound = null;  //todo

            try {
                elementToBeFound = jdbcTemplate.queryForObject(sqlQuery, BeanPropertyRowMapper.newInstance(theClass),
                        identify);
            } catch (EmptyResultDataAccessException e) {
                System.out.println("Not found");
            }
            List<T> oneElementList = Collections.singletonList(elementToBeFound);
            showOutput(oneElementList);

        }
        else {   // SELECT * FROM TABLE_NAME
            String sqlQuery = String.format("SELECT * FROM %s", tableName );
            List<T> listOfAllGroups = jdbcTemplate.query(sqlQuery,
                    BeanPropertyRowMapper.newInstance(theClass));

            showOutput(listOfAllGroups);

        }
        return null;
    }

}
