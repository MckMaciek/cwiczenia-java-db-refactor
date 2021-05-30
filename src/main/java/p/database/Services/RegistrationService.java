package p.database.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import p.database.DatabaseConnection;
import p.database.Models.History;
import p.database.Models.Registration;
import p.database.Operations.DeleteConcrete;
import p.database.Operations.InsertConcrete;
import p.database.Operations.SelectConcrete;
import p.database.Operations.UpdateConcrete;

import java.util.Scanner;

@Service
public class RegistrationService implements TableService {
    private Registration registration;

    final DatabaseConnection databaseConnection;
    final JdbcTemplate jdbcTemplate;
    private final GetColumnNamesService getColumnNamesService;
    private final CheckWhereConditionService checkForWhereConditions;

    private final SelectConcrete<Registration> selectConcrete;
    private final InsertConcrete<Registration> insertConcrete;
    private final DeleteConcrete<Registration> deleteConcrete;
    private final UpdateConcrete<Registration> updateConcrete;


    @Autowired
    public RegistrationService(SelectConcrete<Registration> selectConcrete,
                               InsertConcrete<Registration> insertConcrete,
                               DeleteConcrete<Registration> deleteConcrete,
                               UpdateConcrete<Registration> updateConcrete,

                               DatabaseConnection databaseConnection,
                               GetColumnNamesService getColumnNamesService,
                               CheckWhereConditionService checkForWhereConditions

    ){
        this.databaseConnection = databaseConnection;
        this.jdbcTemplate = new JdbcTemplate();
        this.checkForWhereConditions = checkForWhereConditions;
        this.getColumnNamesService = getColumnNamesService;

        this.selectConcrete = selectConcrete;
        this.insertConcrete = insertConcrete;
        this.deleteConcrete = deleteConcrete;
        this.updateConcrete = updateConcrete;


        jdbcTemplate.setDataSource(databaseConnection.connection());
    }

    public void ScanInput() {
        Scanner getCommandFromUser = new Scanner(System.in);
        System.out.println("[INSERT] ID ");
        String id = getCommandFromUser.nextLine();
        getCommandFromUser = new Scanner(System.in);
        System.out.println("[INSERT] email ");
        String email = getCommandFromUser.nextLine();
        getCommandFromUser = new Scanner(System.in);
        System.out.println("[INSERT] password ");
        String password = getCommandFromUser.nextLine();
        getCommandFromUser = new Scanner(System.in);
        System.out.println("[INSERT] professor_lname ");
        String professor_lname = getCommandFromUser.nextLine();
        getCommandFromUser = new Scanner(System.in);
        System.out.println("[INSERT] professor_fname ");
        String professor_fname = getCommandFromUser.nextLine();

        registration = new Registration.RegistrationBuilder()
                .setId(id)
                .setEmail(email)
                .setPassword(password)
                .setProfessor_last_name(professor_lname)
                .setProfessor_name(professor_fname)
                .build();
    }


    @Override
    public String getName() {
        return "registration_tb";
    }

    @Override
    public void select() {
        String possibleWhereStatement = checkForWhereConditions.checkForWhereConditions(this.getName());
        selectConcrete.select(this.getName(), possibleWhereStatement, Registration.class);
    }

    @Override
    public void update() {
        var columnNames = getColumnNamesService.printColumnNames(this.getName());
        String possibleWhereStatement = checkForWhereConditions.checkForWhereConditions(this.getName());

        registration = new Registration();
        updateConcrete.update(this.getName(), possibleWhereStatement, columnNames, registration,  Registration.class);
    }

    @Override
    public void insert() {
        var columnNames = getColumnNamesService.getNames(this.getName());
        ScanInput();

        insertConcrete.insert(this.getName(), columnNames, registration,  Registration.class);
    }

    @Override
    public void delete() {
        String possibleWhereStatement = checkForWhereConditions.checkForWhereConditions(this.getName());
        deleteConcrete.delete(this.getName(), possibleWhereStatement);
    }
}
