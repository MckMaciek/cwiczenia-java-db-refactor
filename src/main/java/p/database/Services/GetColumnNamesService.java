package p.database.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import p.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetColumnNamesService {

    private final DatabaseConnection databaseConnection;

    @Autowired
    public GetColumnNamesService(){
        databaseConnection = new DatabaseConnection();
    }

    private List<String> getColumnNames(String tableName){

        List<String> colNames = new ArrayList<>();
        DatabaseMetaData metadata = null;
        try {
            Connection con = databaseConnection.connection().getConnection();
            metadata = con.getMetaData();
            ResultSet resultSet =
                    metadata.getColumns(null, null, tableName, null);

            while(resultSet.next()) {
                String columnName = resultSet.getString("COLUMN_NAME");
                colNames.add(columnName);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return colNames.stream().distinct()
                .sorted(Comparator.comparing(String::toString))
                .collect(Collectors.toList());
    }

    public List<String> printColumnNames(String tableName){
        System.out.println("WHERE [your-input]=: " + getColumnNames(tableName) + " [IF USING SELECT YOU CAN ALSO PRESS ENTER]");
        System.out.println("[example-input] id");
        return getColumnNames(tableName);
    }

    public List<String> getNames(String tablename){
        return getColumnNames(tablename);
    }


}
