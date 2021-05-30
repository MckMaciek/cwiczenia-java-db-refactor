package p.database.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import p.database.DatabaseConnection;
import p.database.Models.Group;
import p.database.Operations.DeleteConcrete;
import p.database.Operations.InsertConcrete;
import p.database.Operations.SelectConcrete;
import p.database.Operations.UpdateConcrete;

import java.util.Scanner;

@Service
public class GroupService implements TableService{
    private Group group;

    private final DatabaseConnection databaseConnection;
    private final JdbcTemplate jdbcTemplate;
    private final GetColumnNamesService getColumnNamesService;
    private final CheckWhereConditionService checkForWhereConditions;

    private final SelectConcrete<Group> selectConcrete;
    private final InsertConcrete<Group> insertConcrete;
    private final DeleteConcrete<Group> deleteConcrete;
    private final UpdateConcrete<Group> updateConcrete;

    @Autowired
    public GroupService(SelectConcrete<Group> selectConcrete,
                        InsertConcrete<Group> insertConcrete,
                        DeleteConcrete<Group> deleteConcrete,
                        UpdateConcrete<Group> updateConcrete,

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

    @Override
    public String getName() {
        return "groups_tb";
    }

    public void ScanInput() {
        Scanner getCommandFromUser = new Scanner(System.in);
        System.out.println("[INSERT] ID ");
        String id = getCommandFromUser.nextLine();
        getCommandFromUser = new Scanner(System.in);
        System.out.println("[INSERT] NAME ");
        String name = getCommandFromUser.nextLine();

        group = new Group.GroupBuilder()
                .setName(name)
                .setId(id)
                .build();
    }


    @Override
    public void select() {
        String possibleWhereStatement = checkForWhereConditions.checkForWhereConditions(this.getName());
        selectConcrete.select(this.getName(), possibleWhereStatement, Group.class);
    }

    @Override
    public void update() {
        var columnNames = getColumnNamesService.printColumnNames(this.getName());
        String possibleWhereStatement = checkForWhereConditions.checkForWhereConditions(this.getName());

        group = new Group();
        updateConcrete.update(this.getName(),possibleWhereStatement, columnNames, this.group, Group.class);
    }

    @Override
    public void insert() {
        var columnNames = getColumnNamesService.getNames(this.getName());
        ScanInput();

        insertConcrete.insert(this.getName(), columnNames, this.group,  Group.class);
    }

    @Override
    public void delete() {
        String possibleWhereStatement = checkForWhereConditions.checkForWhereConditions(this.getName());
        deleteConcrete.delete(this.getName(), possibleWhereStatement);
    }
}
