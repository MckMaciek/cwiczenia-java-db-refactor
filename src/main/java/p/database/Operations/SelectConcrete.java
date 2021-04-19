package p.database.Operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import p.database.DatabaseConnection;
import p.database.Models.History;

import java.util.List;
import java.util.Scanner;

@Service
public class SelectConcrete<T> {

    private final JdbcTemplate jdbcTemplate;
    final DatabaseConnection databaseConnection;

    @Autowired
    public SelectConcrete(){
        jdbcTemplate = new JdbcTemplate();
        databaseConnection = new DatabaseConnection();

        jdbcTemplate.setDataSource(databaseConnection.connection());
    }


    public <T>  T SelectConcrete(String tableName, String possibleWhereStatement, Class<T> theClass){
        if(!possibleWhereStatement.equals("")){  // SELECT * FROM TABLE WHERE {ID,NAME,ETC} == ...

            String sqlQuery = String.format("SELECT * FROM %s WHERE %s=?", tableName, possibleWhereStatement);
            Scanner getPossibleGetterFromUser = new Scanner(System.in);
            String identify = getPossibleGetterFromUser.nextLine();

            T elementToBeFound = null;  //todo

            try {
                elementToBeFound = jdbcTemplate.queryForObject(sqlQuery, BeanPropertyRowMapper.newInstance(theClass),
                        identify);
            } catch (EmptyResultDataAccessException e) {
                System.out.println("Not found");
            }

            System.out.println(elementToBeFound); //todo

        }
        else {   // SELECT * FROM TABLE_NAME
            String sqlQuery = String.format("SELECT * FROM %s", tableName );
            List<T> listOfAllGroups = jdbcTemplate.query(sqlQuery,
                    BeanPropertyRowMapper.newInstance(theClass));

            System.out.println(listOfAllGroups);

        }
        return null;
    }

}
