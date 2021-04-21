package p.database.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import p.database.DatabaseConnection;
import p.database.Models.Hall;
import p.database.Operations.DeleteConcrete;
import p.database.Operations.InsertConcrete;
import p.database.Operations.SelectConcrete;
import p.database.Operations.UpdateConcrete;

import java.util.Scanner;

@Service
public class HallService implements TableService {
    private Hall hall;

    final DatabaseConnection databaseConnection;
    final JdbcTemplate jdbcTemplate;
    private final GetColumnNamesService getColumnNamesService;
    private final CheckWhereConditionService checkForWhereConditions;

    private final SelectConcrete<Hall> selectConcrete;
    private final InsertConcrete<Hall> insertConcrete;
    private final DeleteConcrete<Hall> deleteConcrete;
    private final UpdateConcrete<Hall> updateConcrete;

    @Autowired
    public HallService(){
        databaseConnection = new DatabaseConnection();
        jdbcTemplate = new JdbcTemplate();
        checkForWhereConditions = new CheckWhereConditionService();
        getColumnNamesService = new GetColumnNamesService();

        selectConcrete = new SelectConcrete<>();
        insertConcrete = new InsertConcrete<>();
        deleteConcrete = new DeleteConcrete<>();
        updateConcrete = new UpdateConcrete<>();

        jdbcTemplate.setDataSource(databaseConnection.connection());
    }

    public void ScanInput(){
        Scanner getCommandFromUser = new Scanner(System.in);  //todo remove ugly boilerplate code
        System.out.println("[INSERT] id ");
        String id = getCommandFromUser.nextLine();
        getCommandFromUser = new Scanner(System.in);
        System.out.println("[INSERT] Name ");
        String name = getCommandFromUser.nextLine();
        getCommandFromUser = new Scanner(System.in);
        System.out.println("[INSERT] Hall Columns ");
        String hall_columns = getCommandFromUser.nextLine();
        getCommandFromUser = new Scanner(System.in);
        System.out.println("[INSERT] Hall rows ");
        String hall_rows = getCommandFromUser.nextLine();
        getCommandFromUser = new Scanner(System.in);
        System.out.println("[INSERT] add seats ");
        String add_seats = getCommandFromUser.nextLine();
        getCommandFromUser = new Scanner(System.in);
        System.out.println("[INSERT] has section ");
        String has_section = getCommandFromUser.nextLine();

        hall = new Hall.HallBuilder()
                .setId(id)
                .setName(name)
                .setHallColumns(hall_columns)
                .setHallRows(hall_rows)
                .setAddSeats(add_seats)
                .setHasSection(has_section)
                .build();
    }


    @Override
    public String getName() {
        return "hall_tb";
    }

    @Override
    public void select() {
        String possibleWhereStatement = checkForWhereConditions.checkForWhereConditions(this.getName());
        selectConcrete.select(this.getName(), possibleWhereStatement, Hall.class);
    }

    @Override
    public void update() {
        var columnNames = getColumnNamesService.printColumnNames(this.getName());
        String possibleWhereStatement = checkForWhereConditions.checkForWhereConditions(this.getName());

        hall = new Hall();
        updateConcrete.update(this.getName(),possibleWhereStatement, columnNames, this.hall,  Hall.class);
    }

    @Override
    public void insert() {
        var columnNames = getColumnNamesService.getNames(this.getName());

        ScanInput();
        insertConcrete.insert(this.getName(), columnNames, this.hall,  Hall.class);
    }

    @Override
    public void delete() {
        String possibleWhereStatement = checkForWhereConditions.checkForWhereConditions(this.getName());
        deleteConcrete.delete(this.getName(), possibleWhereStatement);
    }
}
