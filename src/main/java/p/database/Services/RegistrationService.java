package p.database.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import p.database.DatabaseConnection;
import p.database.Models.Registration;

import java.util.List;

public class RegistrationService implements TableService {
    private Registration registration;

    final DatabaseConnection databaseConnection;
    final JdbcTemplate jdbcTemplate;

    @Autowired
    public RegistrationService(){
        databaseConnection = new DatabaseConnection();
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(databaseConnection.connection());
    }

    @Override
    public String getName() {
        return "registration_tb";
    }

    @Override
    public void select() {
        String sqlQuery = String.format("SELECT * FROM %s", this.getName());
        List<Registration> listOfAllRegistrations = jdbcTemplate.query(sqlQuery,
                new BeanPropertyRowMapper<>(Registration.class));

        System.out.println(listOfAllRegistrations);
    }

    @Override
    public void update() {
        System.out.println("updated_registration_tb");
    }

    @Override
    public void insert() {
        System.out.println("inserted_registration_tb");
    }

    @Override
    public void delete() {
        System.out.println("deleted_registration_tb");
    }
}
