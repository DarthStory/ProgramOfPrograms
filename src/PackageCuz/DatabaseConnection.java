package PackageCuz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    private static final String AUTO_URL = "jbdc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "Password1!";

    public static String getDbUrl() {
        return AUTO_URL;
    }
    
    public static Connection createAutoDatabase(String AutoDatabase) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(getDbUrl(), USER, PASSWORD);
            Statement stmt = connection.createStatement();

            String createDBQuery = "CREATE DATABASE IF NOT EXISTS " + AutoDatabase;
            stmt.executeUpdate(createDBQuery);
            System.out.println("Database '" + AutoDatabase + "' checked/created successfully.");

            connection = DriverManager.getConnection(getDbUrl(), USER, PASSWORD);
            System.out.println("Connected to the database '" + AutoDatabase + "' successfully.");
            
        } catch (SQLException e) {
        }

        return connection;            
    }  
    
    public static Connection createGpaDatabase(String GPADatabase) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(getDbUrl(), USER, PASSWORD);
            Statement stmt = connection.createStatement();

            String createDBQuery = "CREATE DATABASE IF NOT EXISTS " + GPADatabase;
            stmt.executeUpdate(createDBQuery);
            System.out.println("Database '" + GPADatabase + "' checked/created successfully.");

            connection = DriverManager.getConnection(getDbUrl(), USER, PASSWORD);
            System.out.println("Connected to the database '" + GPADatabase + "' successfully.");
        } catch (SQLException e) {
        }
        return connection;
    }
}
