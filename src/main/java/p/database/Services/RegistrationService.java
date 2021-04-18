package p.database.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import p.database.DatabaseConnection;
import p.database.Models.Group;
import p.database.Models.History;
import p.database.Models.Registration;


public class RegistrationService implements TableService {
    private Registration registration;

    final DatabaseConnection databaseConnection;
    final JdbcTemplate jdbcTemplate;
    private final GetColumnNamesService getColumnNamesService;
    private final CheckWhereConditionService checkForWhereConditions;
    private final SelectConcrete<Group> selectConcrete;

    @Autowired
    public RegistrationService(){
        databaseConnection = new DatabaseConnection();
        jdbcTemplate = new JdbcTemplate();
        checkForWhereConditions = new CheckWhereConditionService();
        getColumnNamesService = new GetColumnNamesService();
        selectConcrete = new SelectConcrete<>();


        jdbcTemplate.setDataSource(databaseConnection.connection());
    }

    @Override
    public String getName() {
        return "registration_tb";
    }

    @Override
    public void select() {
        String possibleWhereStatement = checkForWhereConditions.checkForWhereConditions(this.getName());
        selectConcrete.SelectConcrete(this.getName(), possibleWhereStatement, History.class);
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
