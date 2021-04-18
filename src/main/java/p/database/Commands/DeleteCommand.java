package p.database.Commands;

import org.springframework.beans.factory.annotation.Autowired;
import p.database.Command;
import p.database.Services.*;
import p.database.TableOptions;

public class DeleteCommand implements Command {

    public final TableOptions tableOptions;

    @Autowired
    public DeleteCommand(){
        tableOptions = new TableOptions();
    }

    @Override
    public void execute() {
        TableService tableService = tableOptions.selectTable();
        tableService.delete();
    }

    @Override
    public String description() {
        return "[D]ELETE VALUES";
    }
}
