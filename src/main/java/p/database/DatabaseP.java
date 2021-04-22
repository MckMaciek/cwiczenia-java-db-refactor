package p.database;

import p.database.Commands.*;

import java.util.ArrayList;
import java.util.List;

public class DatabaseP {

    public static void launch(String args[]){

        SelectCommand selectCommand = new SelectCommand();
        InsertCommand insertCommand = new InsertCommand();
        UpdateCommand updateCommand = new UpdateCommand();
        DeleteCommand deleteCommand = new DeleteCommand();
        ExitCommand   exitCommand   = new ExitCommand();

        List<Command> commands = new ArrayList<>(){{
            add(selectCommand);
            add(insertCommand);
            add(updateCommand);
            add(deleteCommand);
            add(exitCommand);
        }};

        RunCommands runCommands = new RunCommands(commands);
        runCommands.showMenu();
    }
}
