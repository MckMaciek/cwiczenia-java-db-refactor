package p.database.Commands;

import org.springframework.beans.factory.annotation.Autowired;
import p.database.Command;
import p.database.Services.*;
import p.database.TableOptions;


public class InsertCommand implements Command {

    public final TableOptions tableOptions;

    @Autowired
    public InsertCommand(){
        tableOptions = new TableOptions();
    }

    @Override
    public void execute() {
        TableService tableService = tableOptions.selectTable();
        tableService.insert();
    }

    @Override
    public String description() {
        return "[I]NSERT VALUES";
    }
}
