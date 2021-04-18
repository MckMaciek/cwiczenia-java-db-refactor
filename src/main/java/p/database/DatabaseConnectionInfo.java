package p.database;

public class DatabaseConnectionInfo {

    //db_system_rozmieszczania_studentow_na_egzaminach
    //db_java_srsne
    protected static final String databaseName = "db_system_rozmieszczania_studentow_na_egzaminach";
    protected static final String portNumber = "3306";
    protected static final String url = "jdbc:mysql://localhost:" + portNumber + "/"
            + databaseName + "?useLegacyDatetimeCode=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";

    protected static final String user = "root";
    protected static final String password = "";

}
