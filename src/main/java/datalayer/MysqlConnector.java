package datalayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class MysqlConnector {
    //resourcebundle takes values from property file so you dont have to hardcode database credentials
    private static ResourceBundle rb = ResourceBundle.getBundle("connector");
    private static MysqlConnector instance;
    private String databaseName = rb.getString("databaseName");
    private String user = rb.getString("user");
    private String password = rb.getString("password");

    public static MysqlConnector getInstance() {
        if(instance == null) {
            instance = new MysqlConnector();
        }
        return instance;
    }

    //Create a connection to the database
    public Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName +"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", user, password);
            return connection;
        } catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
