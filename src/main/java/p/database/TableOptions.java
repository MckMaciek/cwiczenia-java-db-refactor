package p.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import p.database.Models.History;
import p.database.Services.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@Service
public class TableOptions {

    private List<p.database.Services.TableService> tableServices;

    private final GroupService groupService;
    private final HallService hallService;
    private final HistoryService historyService;
    private final RegistrationService registrationService;
    private final StudentService studentService;

    @Autowired
    public TableOptions(
            GroupService groupService,
            HallService hallService,
            HistoryService historyService,
            RegistrationService registrationService,
            StudentService studentService

    ){
        this.groupService = groupService;
        this.hallService = hallService;
        this.historyService = historyService;
        this.registrationService = registrationService;
        this.studentService = studentService;


        tableServices = new ArrayList<>(){{
            add(groupService);
            add(hallService);
            add(historyService);
            add(registrationService);
            add(studentService);
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
