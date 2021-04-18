package p.database;

import p.database.Services.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TableOptions {

    private List<p.database.Services.TableService> tableServices;

    public TableOptions(){
        tableServices = new ArrayList<>(){{
            add(new GroupService());
            add(new HallService());
            add(new HistoryService());
            add(new RegistrationService());
            add(new StudentService());
        }};
    }

    public TableService selectTable(){

        tableServices.forEach((element) -> System.out.println(element.getName()));
        Scanner getCommandFromUser = new Scanner(System.in);

        String choice = getCommandFromUser.nextLine();

        TableService choosenTable = tableServices.stream().filter(element ->{
            return element.getName().equals(choice);   // GET TABLE WITH FULL NAMES
        })
                .findFirst().get();

        return choosenTable;
    }

}
