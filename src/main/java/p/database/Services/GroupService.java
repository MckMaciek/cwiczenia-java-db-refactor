package p.database.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import p.database.DatabaseConnection;
import p.database.Models.Group;

import java.util.Scanner;


public class GroupService implements TableService{
    private Group group;

    final DatabaseConnection databaseConnection;
    final JdbcTemplate jdbcTemplate;
    private final GetColumnNamesService getColumnNamesService;
    private final CheckWhereConditionService checkForWhereConditions;
    private final SelectConcrete<Group> selectConcrete;
    private final InsertConcrete<Group> insertConcrete;

    @Autowired
    public GroupService(){
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
        return "groups_tb";
    }


    @Override
    public void select() {
        String possibleWhereStatement = checkForWhereConditions.checkForWhereConditions(this.getName());
        selectConcrete.SelectConcrete(this.getName(), possibleWhereStatement, Group.class);
    }

    @Override
    public void update() {
        System.out.println("updated group_tb");
    }

    @Override
    public void insert() {
        var columnNames = getColumnNamesService.printColumnNames(this.getName());

        Scanner getCommandFromUser = new Scanner(System.in);
        System.out.println("ID ");
        Long id = getCommandFromUser.nextLong();
        getCommandFromUser = new Scanner(System.in);
        System.out.println("NAME ");
        String name = getCommandFromUser.nextLine();

        group = new Group.GroupBuilder()
                .setName(name)
                .setId(id)
                .build();

        insertConcrete.InsertConcrete(this.getName(), columnNames, group,  Group.class);

    }

    @Override
    public void delete() {
        System.out.println("deleted group_tb");
    }
}
