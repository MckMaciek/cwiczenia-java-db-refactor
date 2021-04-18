package p.database.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import p.database.DatabaseConnection;
import p.database.Models.History;

import java.util.List;

public class HistoryService implements TableService {
    private History history;

    final DatabaseConnection databaseConnection;
    final JdbcTemplate jdbcTemplate;

    @Autowired
    public HistoryService(){
        databaseConnection = new DatabaseConnection();
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(databaseConnection.connection());
    }

    @Override
    public String getName() {
        return "history_tb";
    }

    @Override
    public void select() {
        String sqlQuery = String.format("SELECT * FROM %s", this.getName());
        List<HistoryService> listOfAllHistories = jdbcTemplate.query(sqlQuery,
                new BeanPropertyRowMapper<>(HistoryService.class));

        System.out.println(listOfAllHistories);
    }

    @Override
    public void update() {
        System.out.println("updated history_tb");
    }

    @Override
    public void insert() {
        System.out.println("inserted history_tb");
    }

    @Override
    public void delete() {
        System.out.println("deleted history_tb");
    }
}
