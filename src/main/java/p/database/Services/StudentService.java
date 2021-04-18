package p.database.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import p.database.DatabaseConnection;
import p.database.Models.Student;

import java.util.List;

public class StudentService implements TableService {
    private Student student;

    final DatabaseConnection databaseConnection;
    final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentService(){
        databaseConnection = new DatabaseConnection();
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(databaseConnection.connection());
    }

    @Override
    public String getName() {
        return "students_tb";
    }

    @Override
    public void select() {
        String sqlQuery = String.format("SELECT * FROM %s", this.getName());
        List<Student> listOfAllStudents = jdbcTemplate.query(sqlQuery,
                new BeanPropertyRowMapper<>(Student.class));

        System.out.println(listOfAllStudents);
    }

    @Override
    public void update() {
        System.out.println("updated_students");
    }

    @Override
    public void insert() {
        System.out.println("inserted_students");
    }

    @Override
    public void delete() {
        System.out.println("deleted_students");
    }
}
