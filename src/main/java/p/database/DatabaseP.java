package p.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p.database.Commands.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseP {

    private final SelectCommand selectCommand;
    private final InsertCommand insertCommand;
    private final UpdateCommand updateCommand;
    private final DeleteCommand deleteCommand;
    private final ExitCommand exitCommand;

    private static List<Command> commands;

    @Autowired
    public DatabaseP(SelectCommand selectCommand,
                     InsertCommand insertCommand,
                     UpdateCommand updateCommand,
                     DeleteCommand deleteCommand,
                     ExitCommand exitCommand) {

        this.selectCommand = selectCommand;
        this.insertCommand = insertCommand;
        this.updateCommand = updateCommand;
        this.deleteCommand = deleteCommand;
        this.exitCommand = exitCommand;

        commands = new ArrayList<>(){{
            add(selectCommand);
            add(insertCommand);
            add(updateCommand);
            add(deleteCommand);
            add(exitCommand);
        }};

        this.launch(null);
    }

    public void launch(String args[]){

        RunCommands runCommands = new RunCommands(commands);
        runCommands.showMenu();
    }
}
