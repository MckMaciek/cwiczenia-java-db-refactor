package p.database.Commands;

import org.springframework.stereotype.Component;
import p.database.Command;


@Component
public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.out.println("EXITING");
    }

    @Override
    public String description() {
        return "[E]XIT";
    }
}
