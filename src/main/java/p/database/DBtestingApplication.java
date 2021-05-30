package p.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class DBtestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DBtestingApplication.class, args);

	}

}
