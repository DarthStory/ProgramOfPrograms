package AutomobileInventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {

    private static final String AUTO_URL = "jdbc:mysql://localhost:3306/";
    private static String USER;
    private static String PASSWORD;

    public static void setCredentials(String username, String password) {
        USER = username; 
        PASSWORD = password;
    }

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
            String createTableQuery = "CREATE TABLE IF NOT EXISTS Automobiles (id INT AUTO_INCREMENT PRIMARY KEY,make VARCHAR(50), model VARCHAR(50), color VARCHAR(30), year INT,mileage INT)"; 
            stmt.executeUpdate(createTableQuery);
            System.out.println("Table 'Automobiles' checked/created successfully.");

        } catch (SQLException e) {
            System.out.println(e);
        }   
    }

    public static List<Automobile> loadAutomobiles(Connection connection) throws SQLException {
        List<Automobile> automobiles = new ArrayList<>();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT make, model, color, year, mileage FROM Automobiles");

        while (rs.next()) {
            String make = rs.getString("make");
            String model = rs.getString("model");
            String color = rs.getString("color");
            int year = rs.getInt("year");
            int mileage = rs.getInt("mileage");

            Automobile auto = new Automobile(make, model, color, year, mileage);
            automobiles.add(auto);
        }
        return automobiles;
    }

    public static void saveAutomobiles(Connection connection, List<Automobile> automobiles) throws SQLException {
        Statement stmt = connection.createStatement();
        // Clear the existing data
        stmt.executeUpdate("DELETE FROM Automobiles");

        // Insert the current list of automobiles
        String insertQuery = "INSERT INTO Automobiles (make, model, color, year, mileage) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(insertQuery);

        for (Automobile auto : automobiles) {
            pstmt.setString(1, auto.getMake());
            pstmt.setString(2, auto.getModel());
            pstmt.setString(3, auto.getColor());
            pstmt.setInt(4, auto.getYear());
            pstmt.setInt(5, auto.getMileage());
            pstmt.executeUpdate();
        }
    }    
}
