package datalayer;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnector {

    private static MysqlConnector instance;
    private String databaseName = "sys";
    private String user = "root";
    private String password = "Password123";

    public static MysqlConnector getInstance() {
        if(instance == null) {
            return new MysqlConnector();
        } else {
            return instance;
        }
    }

    public Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName, user, password);
            return connection;
        } catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
