package p.database;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.JdbcTemplate;
import p.database.Models.Student;
import p.database.Operations.SelectConcrete;

import static org.mockito.Mockito.mock;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DataBaseSingletonTesting {

    @Mock
    SelectConcrete<Student> selectConcrete;

    @InjectMocks
    JdbcTemplate jdbcTemplate;
    DatabaseConnection databaseConnection;

    



}
