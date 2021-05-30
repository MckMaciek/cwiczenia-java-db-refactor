package p.database;

import org.springframework.stereotype.Service;
import p.database.Commands.ExitCommand;
import java.util.List;
import java.util.Scanner;

@Service
public class RunCommands {

    List<Command> commands;

    public RunCommands(List<Command> _commands) {
        this.commands = _commands;
    }

    public p.database.Command getInputCommand(){

        commands.forEach((element) -> System.out.println(element.description()));
        Scanner getCommandFromUser = new Scanner(System.in);
        char choice = getCommandFromUser.nextLine().charAt(0);

        Command toBeExecuted = commands.stream().filter(element ->{
            return element.description().charAt(1) == choice;   // GET S or U or D or I etc ...
        })
        .findFirst().get();

        return toBeExecuted;
    }

    public void showMenu(){

        Command toBeExecuted;
        do {
            toBeExecuted = getInputCommand();
            toBeExecuted.execute();

        }while(!(toBeExecuted instanceof ExitCommand));
    }
}
