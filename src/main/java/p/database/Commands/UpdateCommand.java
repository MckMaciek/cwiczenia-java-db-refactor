package p.database.Commands;

import org.springframework.beans.factory.annotation.Autowired;
import p.database.Command;
import p.database.Services.*;
import p.database.TableOptions;


public class UpdateCommand implements Command {

    public final TableOptions tableOptions;

    @Autowired
    public UpdateCommand(){
        tableOptions = new TableOptions();
    }

    @Override
    public void execute() {
        TableService tableService = tableOptions.selectTable();
        tableService.update();
    }

    @Override
    public String description() {
        return "[U]PDATE VALUES";
    }
}
