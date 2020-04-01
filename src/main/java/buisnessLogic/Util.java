package buisnessLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String DB_URL = "jdbc:h2:~/test";
    private static final String DB_USERNAME = "sa";
    private static final String DB_PASS = "";

    public Connection getConnection() {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASS);
            System.out.println("Connection OK");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection ERROR");
        }
        return connection;
    }

}
