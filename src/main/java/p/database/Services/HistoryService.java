package p.database.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import p.database.DatabaseConnection;
import p.database.Models.History;
import p.database.Operations.InsertConcrete;
import p.database.Operations.SelectConcrete;

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

    @Autowired
    public HistoryService(){
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
        return "history_tb";
    }

    public void ScanInput() {
        Scanner getCommandFromUser = new Scanner(System.in);
        System.out.println("ID ");
        Long id = getCommandFromUser.nextLong();
        getCommandFromUser = new Scanner(System.in);
        System.out.println("NAME ");
        String name = getCommandFromUser.nextLine();
        getCommandFromUser = new Scanner(System.in);
        System.out.println("NAME ");
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
        selectConcrete.SelectConcrete(this.getName(), possibleWhereStatement, History.class);
    }

    @Override
    public void update() {
        System.out.println("updated history_tb");
    }

    @Override
    public void insert() {
        var columnNames = getColumnNamesService.printColumnNames(this.getName());
        ScanInput();

        insertConcrete.InsertConcrete(this.getName(), columnNames, history,  History.class);
    }

    @Override
    public void delete() {
        System.out.println("deleted history_tb");
    }
}
