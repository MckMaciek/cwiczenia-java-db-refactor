package p.database.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.JdbcTemplate;
import p.database.DatabaseConnection;
import p.database.Models.Group;
import p.database.Models.Hall;

import java.util.Scanner;


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

        Scanner getCommandFromUser = new Scanner(System.in);
        hall = new Hall.HallBuilder()
                .setId(getCommandFromUser.nextLong())
                .setName(getCommandFromUser.nextLine())
                .setHallColumns(getCommandFromUser.nextLine())
                .setHallRows(getCommandFromUser.nextLine())
                .setAddSeats(getCommandFromUser.nextLine())
                .setHasSection(getCommandFromUser.nextLine())
                .build();

        insertConcrete.InsertConcrete(this.getName(), columnNames, hall,  Hall.class);

    }

    @Override
    public void delete() {
        System.out.println("deleted hall_tb");
    }
}
