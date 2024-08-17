package PackageCuz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    private static final String AUTO_URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "Password1!";

    public static String getDbUrl() {
        return AUTO_URL;
    }
    public static String getUser() {
        return USER;
    }
    public static String getPassword() {
        return PASSWORD;
    }
    
    public static Connection createAutoDatabase(String AutoDatabase) {
        Connection connection = null;        
            try {
                connection = DriverManager.getConnection(getDbUrl(), getUser(), getPassword());
                Statement stmt = connection.createStatement();
                String createDBQuery = "CREATE DATABASE IF NOT EXISTS " + AutoDatabase;
                stmt.executeUpdate(createDBQuery);
                connection = DriverManager.getConnection(getDbUrl() + AutoDatabase, getUser(), getPassword()); 
                
                createAutoTable(connection);
            }
            catch (SQLException e) {
                System.out.println(e);
            }
        return connection;            
    }
    public static void createAutoTable(Connection connection) {
        if(connection == null) {
            System.out.println("Connection is not established.");
            return;
        }
        try {
            Statement stmt = connection.createStatement();
            String createTableQuery = "CREATE TABLE IF NOT EXISTS Automobiles (id INT AUTO_INCREMENT PRIMARY KEY,make VARCHAR(50), model VARCHAR(50), color VARCHAR(30), year INT,milage INT)"; 
            stmt.executeUpdate(createTableQuery);
            System.out.println("Table 'Automobiles' checked/created successfully.");

        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
    
    public static Connection createGpaDatabase(String GPADatabase) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(getDbUrl(), getUser(), getPassword());
            Statement stmt = connection.createStatement();

            String createDBQuery = "CREATE DATABASE IF NOT EXISTS " + GPADatabase;
            stmt.executeUpdate(createDBQuery);
            System.out.println("Database '" + GPADatabase + "' checked/created successfully.");

            connection = DriverManager.getConnection(getDbUrl() + GPADatabase, getUser(), getPassword());
            System.out.println("Connected to the database '" + GPADatabase + "' successfully.");
        } catch (SQLException e) {
        }
        return connection;
    }
}
