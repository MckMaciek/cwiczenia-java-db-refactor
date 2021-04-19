package p.database.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import p.database.DatabaseConnection;
import p.database.Models.Group;
import p.database.Models.Hall;
import p.database.Models.Student;
import p.database.Operations.InsertConcrete;
import p.database.Operations.SelectConcrete;

import java.util.Scanner;

@Service
public class StudentService implements TableService {
    private Student student;

    final DatabaseConnection databaseConnection;
    final JdbcTemplate jdbcTemplate;
    private final GetColumnNamesService getColumnNamesService;
    private final CheckWhereConditionService checkForWhereConditions;

    private final SelectConcrete<Student> selectConcrete;
    private final InsertConcrete<Student> insertConcrete;


    @Autowired
    public StudentService(){
        databaseConnection = new DatabaseConnection();
        jdbcTemplate = new JdbcTemplate();
        checkForWhereConditions = new CheckWhereConditionService();
        getColumnNamesService = new GetColumnNamesService();

        selectConcrete = new SelectConcrete<>();
        insertConcrete = new InsertConcrete<>();

        jdbcTemplate.setDataSource(databaseConnection.connection());
    }

    @Override
    public String getName() {
        return "students_tb";
    }

    public void scanInput(){
        Scanner getCommandFromUser = new Scanner(System.in);  //todo remove ugly boilerplate code
        System.out.println("id ");
        Long id = getCommandFromUser.nextLong();
        getCommandFromUser = new Scanner(System.in);
        System.out.println("Fname ");
        String fname = getCommandFromUser.nextLine();
        getCommandFromUser = new Scanner(System.in);
        System.out.println("Lname ");
        String lname = getCommandFromUser.nextLine();
        getCommandFromUser = new Scanner(System.in);
        System.out.println("Group ");
        String group = getCommandFromUser.nextLine();
        getCommandFromUser = new Scanner(System.in);
        System.out.println("Index number");
        String index = getCommandFromUser.nextLine();
        getCommandFromUser = new Scanner(System.in);
        System.out.println("Sub Group ");
        String sub_group = getCommandFromUser.nextLine();

        student = new Student.StudentBuilder()
                .setId(id)
                .setFname(fname)
                .setLname(lname)
                .setGroup(group)
                .setIndexNumber(index)
                .setSub_group(sub_group)
                .build();

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
        var columnNames = getColumnNamesService.printColumnNames(this.getName());

        scanInput();
        insertConcrete.InsertConcrete(this.getName(), columnNames, this.student,  Student.class);
    }

    @Override
    public void delete() {
        System.out.println("deleted_students");
    }
}
