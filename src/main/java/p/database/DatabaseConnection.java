package p.database;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.stereotype.Service;

@Service
public class DatabaseConnection extends DatabaseConnectionInfo{

    private MysqlDataSource mysqlDataSource = null;

    public DatabaseConnection() {
    }

    public  MysqlDataSource connection() {
        if (mysqlDataSource == null) {
            try {
                mysqlDataSource = new MysqlDataSource();

                mysqlDataSource.setUrl(url);
                mysqlDataSource.setUser(user);
                mysqlDataSource.setPassword(password);

                return mysqlDataSource;
            } catch (Exception e) {
                e.printStackTrace();
            }

            return mysqlDataSource;
        }

        return mysqlDataSource;
    }

}