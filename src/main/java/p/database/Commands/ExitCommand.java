package p.database.Commands;

import p.database.Command;

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
