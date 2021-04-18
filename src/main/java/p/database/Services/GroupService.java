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

    @Autowired
    public GroupService(){
        databaseConnection = new DatabaseConnection();
        jdbcTemplate = new JdbcTemplate();
        checkForWhereConditions = new CheckWhereConditionService();
        getColumnNamesService = new GetColumnNamesService();
        selectConcrete = new SelectConcrete<>();

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
        Scanner getCommandFromUser = new Scanner(System.in);
        group = new Group.GroupBuilder()
                .setName(getCommandFromUser.nextLine())
                .setId(getCommandFromUser.nextLong())
                .build();

        String sqlQuery = "INSERT INTO GROUPS_TB(ID,NAME) VALUES (?,?)";
        jdbcTemplate.update(sqlQuery,
                new Object[] {group.getId(), group.getName()});
    }

    @Override
    public void delete() {
        System.out.println("deleted group_tb");
    }
}
