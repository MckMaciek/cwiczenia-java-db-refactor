package p.database;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.util.Assert;
import p.database.Commands.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class RunCommandsTest {

//    static RunCommands runCommands;
//
//    @BeforeAll
//    public static void addAllCommandsToList() {
//        runCommands = mock(RunCommands.class);
//
//        runCommands.commands = new ArrayList<>() {{
//            add(new DeleteCommand());
//            add(new InsertCommand());
//            add(new SelectCommand());
//            add(new ExitCommand());
//            add(new UpdateCommand());
//        }};
//    }
//
//    @Test
//    void assertThatThereAreNoNullValuesInList() {
//        Assert.noNullElements(runCommands.commands, "NULL VALUE IN LIST");
//    }
//
//    @Test
//    void assertThatLengthOfArrayIsGreaterThanZero(){
//        Assert.notEmpty(runCommands.commands, "EMPTY LIST");
//    }
//
//    @Test
//    void assertThatEveryElementOfTheListIsInstanceOfCommand(){
//        runCommands.commands.forEach(command ->{
//            Assert.isInstanceOf(Command.class, command);
//        });
//    }


}