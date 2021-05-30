package p.database.Commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p.database.Command;
import p.database.Services.*;
import p.database.TableOptions;

@Component
public class SelectCommand implements Command {

    private final TableOptions tableOptions;

    @Autowired
    public SelectCommand(TableOptions tableOptions){
        this.tableOptions = tableOptions;
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
