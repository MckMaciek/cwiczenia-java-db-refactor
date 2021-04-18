package p.database.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import p.database.DatabaseConnection;
import p.database.Models.Hall;

import java.util.List;

public class HallService implements TableService {
    private Hall hall;

    final DatabaseConnection databaseConnection;
    final JdbcTemplate jdbcTemplate;

    @Autowired
    public HallService(){
        databaseConnection = new DatabaseConnection();
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(databaseConnection.connection());
    }


    @Override
    public String getName() {
        return "hall_tb";
    }

    @Override
    public void select() {
        String sqlQuery = String.format("SELECT * FROM %s", this.getName());
        List<Hall> listOfAllHalls = jdbcTemplate.query(sqlQuery,
                new BeanPropertyRowMapper<>(Hall.class));

        System.out.println(listOfAllHalls);
    }

    @Override
    public void update() {
        System.out.println("updated hall_tb");
    }

    @Override
    public void insert() {
        System.out.println("inserted hall_tb");
    }

    @Override
    public void delete() {
        System.out.println("deleted hall_tb");
    }
}
