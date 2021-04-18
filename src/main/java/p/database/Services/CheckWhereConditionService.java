package p.database.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class CheckWhereConditionService {

    private final GetColumnNamesService getColumnNamesService;

    @Autowired
    public CheckWhereConditionService(){
        getColumnNamesService = new GetColumnNamesService();
    }

    public String checkForWhereConditions(String tableName){
        List<String> possibleGetters = getColumnNamesService.printColumnNames(tableName);
        Scanner getPossibleGetterFromUser = new Scanner(System.in);
        String userInput = getPossibleGetterFromUser.nextLine();


        String possibleOutput = possibleGetters.stream().filter(element ->{
            return element.equals(userInput);
        }).findFirst().orElse("");

        return possibleOutput;
    }
}
