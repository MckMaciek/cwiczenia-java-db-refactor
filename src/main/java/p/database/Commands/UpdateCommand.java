package p.database.Commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p.database.Command;
import p.database.Services.*;
import p.database.TableOptions;

@Component
public class UpdateCommand implements Command {

    private final TableOptions tableOptions;

    @Autowired
    public UpdateCommand(TableOptions tableOptions){
        this.tableOptions = tableOptions;
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
