package p.database.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import p.database.DatabaseConnection;
import p.database.Models.Hall;
import p.database.Operations.InsertConcrete;
import p.database.Operations.SelectConcrete;

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

    @Autowired
    public HallService(){
        databaseConnection = new DatabaseConnection();
        jdbcTemplate = new JdbcTemplate();
        checkForWhereConditions = new CheckWhereConditionService();
        getColumnNamesService = new GetColumnNamesService();

        selectConcrete = new SelectConcrete<>();
        insertConcrete = new InsertConcrete<>();

        jdbcTemplate.setDataSource(databaseConnection.connection());
    }

    public void ScanInput(){
        Scanner getCommandFromUser = new Scanner(System.in);  //todo remove ugly boilerplate code
        System.out.println("id ");
        Long id = getCommandFromUser.nextLong();
        getCommandFromUser = new Scanner(System.in);
        System.out.println("Name ");
        String name = getCommandFromUser.nextLine();
        getCommandFromUser = new Scanner(System.in);
        System.out.println("Hall Columns ");
        String hall_columns = getCommandFromUser.nextLine();
        getCommandFromUser = new Scanner(System.in);
        System.out.println("Hall rows ");
        String hall_rows = getCommandFromUser.nextLine();
        getCommandFromUser = new Scanner(System.in);
        System.out.println("add seats ");
        String add_seats = getCommandFromUser.nextLine();
        getCommandFromUser = new Scanner(System.in);
        System.out.println("has section ");
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
        selectConcrete.SelectConcrete(this.getName(), possibleWhereStatement, Hall.class);
    }

    @Override
    public void update() {
        System.out.println("updated hall_tb");
    }

    @Override
    public void insert() {
        var columnNames = getColumnNamesService.printColumnNames(this.getName());

        ScanInput();
        insertConcrete.InsertConcrete(this.getName(), columnNames, this.hall,  Hall.class);

    }

    @Override
    public void delete() {
        System.out.println("deleted hall_tb");
    }
}
