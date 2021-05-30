package p.database.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import p.database.DatabaseConnection;
import p.database.Models.Hall;
import p.database.Models.History;
import p.database.Operations.DeleteConcrete;
import p.database.Operations.InsertConcrete;
import p.database.Operations.SelectConcrete;
import p.database.Operations.UpdateConcrete;

import java.util.Scanner;

@Service
public class HistoryService implements TableService {
    private History history;

    final DatabaseConnection databaseConnection;
    final JdbcTemplate jdbcTemplate;
    private final GetColumnNamesService getColumnNamesService;
    private final CheckWhereConditionService checkForWhereConditions;

    private final SelectConcrete<History> selectConcrete;
    private final InsertConcrete<History> insertConcrete;
    private final DeleteConcrete<History> deleteConcrete;
    private final UpdateConcrete<History> updateConcrete;

    @Autowired
    public HistoryService(SelectConcrete<History> selectConcrete,
                          InsertConcrete<History> insertConcrete,
                          DeleteConcrete<History> deleteConcrete,
                          UpdateConcrete<History> updateConcrete,

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
        return "history_tb";
    }

    public void ScanInput() {
        Scanner getCommandFromUser = new Scanner(System.in);
        System.out.println("[INSERT] ID ");
        String id = getCommandFromUser.nextLine();
        getCommandFromUser = new Scanner(System.in);
        System.out.println("[INSERT] NAME ");
        String name = getCommandFromUser.nextLine();
        getCommandFromUser = new Scanner(System.in);
        System.out.println("[INSERT] NAME ");
        String iterations = getCommandFromUser.nextLine();

        history = new History.HistoryBuilder()
                .setId(id)
                .setName(name)
                .setIterations(iterations)
                .build();

    }

    @Override
    public void select() {
        String possibleWhereStatement = checkForWhereConditions.checkForWhereConditions(this.getName());
        selectConcrete.select(this.getName(), possibleWhereStatement, History.class);
    }

    @Override
    public void update() {
        var columnNames = getColumnNamesService.printColumnNames(this.getName());
        String possibleWhereStatement = checkForWhereConditions.checkForWhereConditions(this.getName());

        history = new History();
        updateConcrete.update(this.getName(), possibleWhereStatement, columnNames, history,  History.class);
    }

    @Override
    public void insert() {
        var columnNames = getColumnNamesService.getNames(this.getName());
        ScanInput();

        insertConcrete.insert(this.getName(), columnNames, history,  History.class);
    }

    @Override
    public void delete() {
        String possibleWhereStatement = checkForWhereConditions.checkForWhereConditions(this.getName());
        deleteConcrete.delete(this.getName(), possibleWhereStatement);
    }
}
