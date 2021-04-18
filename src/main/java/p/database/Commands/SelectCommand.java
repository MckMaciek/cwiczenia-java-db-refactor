package p.database.Commands;

import org.springframework.beans.factory.annotation.Autowired;
import p.database.Command;
import p.database.Services.*;
import p.database.TableOptions;


public class SelectCommand implements Command {

    public final TableOptions tableOptions;

    @Autowired
    public SelectCommand(){
        tableOptions = new TableOptions();
    }

    @Override
    public void execute() {
        TableService tableService = tableOptions.selectTable();
        tableService.select();
    }

    @Override
    public String description() {
        return "[S]ELECT VALUES";
    }
}
