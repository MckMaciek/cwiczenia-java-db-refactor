package p.database.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import p.database.DatabaseConnection;
import p.database.Models.Group;

import java.util.List;
import java.util.Scanner;


public class GroupService implements TableService{
    private Group group;

    final DatabaseConnection databaseConnection;
    final JdbcTemplate jdbcTemplate;
    private final GetColumnNamesService getColumnNamesService;
    private final CheckWhereConditionService checkForWhereConditions;

    @Autowired
    public GroupService(){
        databaseConnection = new DatabaseConnection();
        jdbcTemplate = new JdbcTemplate();
        checkForWhereConditions = new CheckWhereConditionService();
        getColumnNamesService = new GetColumnNamesService();

        jdbcTemplate.setDataSource(databaseConnection.connection());
    }

    @Override
    public String getName() {
        return "groups_tb";
    }


    @Override
    public void select() {
        String possibleWhereStatement = checkForWhereConditions.checkForWhereConditions(this.getName());

        if(!possibleWhereStatement.equals("")){  // SELECT * FROM GROUP WHERE {ID,NAME,ETC} == ...

            String sqlQuery = String.format("SELECT * FROM %s WHERE %s=?", this.getName(), possibleWhereStatement);
            Scanner getPossibleGetterFromUser = new Scanner(System.in);
            String identify = getPossibleGetterFromUser.nextLine();

            Group GroupToBeFound = null;
            try {
                GroupToBeFound = jdbcTemplate.queryForObject(sqlQuery, BeanPropertyRowMapper.newInstance(Group.class),
                            identify);
            } catch (EmptyResultDataAccessException e) {
                System.out.println("Not found");
            }

            System.out.println(GroupToBeFound);

        }
        else {   // SELECT * FROM GROUP
            String sqlQuery = String.format("SELECT * FROM %s", this.getName());
            List<Group> listOfAllGroups = jdbcTemplate.query(sqlQuery,
                    new BeanPropertyRowMapper<>(Group.class));

            System.out.println(listOfAllGroups);

        }
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
