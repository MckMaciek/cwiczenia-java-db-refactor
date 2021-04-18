package p.database.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import p.database.DatabaseConnection;
import p.database.Models.Group;
import p.database.Models.Student;


public class StudentService implements TableService {
    private Student student;

    final DatabaseConnection databaseConnection;
    final JdbcTemplate jdbcTemplate;
    private final GetColumnNamesService getColumnNamesService;
    private final CheckWhereConditionService checkForWhereConditions;
    private final SelectConcrete<Group> selectConcrete;

    @Autowired
    public StudentService(){
        databaseConnection = new DatabaseConnection();
        jdbcTemplate = new JdbcTemplate();
        checkForWhereConditions = new CheckWhereConditionService();
        getColumnNamesService = new GetColumnNamesService();
        selectConcrete = new SelectConcrete<>();

        jdbcTemplate.setDataSource(databaseConnection.connection());
    }

    @Override
    public String getName() {
        return "students_tb";
    }

    @Override
    public void select() {
        String possibleWhereStatement = checkForWhereConditions.checkForWhereConditions(this.getName());
        selectConcrete.SelectConcrete(this.getName(), possibleWhereStatement, Student.class);
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
