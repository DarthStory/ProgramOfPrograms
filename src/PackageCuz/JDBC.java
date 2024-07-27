package PackageCuz;


    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import java.sql.Statement;
    import java.sql.ResultSet;
    
    public class JDBC {
        public static void main(String[] args) {
            Connection connection = null;
            try {
                // Load the SQLite JDBC driver
                Class.forName("org.sqlite.JDBC");
                
                // Create a connection to the database
                connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
                
                System.out.println("Connection to SQLite has been established.");
                
                // Create a statement object to execute SQL queries
                Statement statement = connection.createStatement();
                
                // Create a new table
                String createTableSQL = "CREATE TABLE IF NOT EXISTS users ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + "name TEXT NOT NULL,"
                        + "email TEXT NOT NULL"
                        + ");";
                statement.executeUpdate(createTableSQL);
                
                // Insert data into the table
                String insertSQL = "INSERT INTO users (name, email) VALUES ('John Doe', 'john.doe@example.com');";
                statement.executeUpdate(insertSQL);
                
                // Retrieve data from the table
                String selectSQL = "SELECT * FROM users;";
                ResultSet resultSet = statement.executeQuery(selectSQL);
                
                // Print the results
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
                }
                
                // Close the statement and result set
                resultSet.close();
                statement.close();
                
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }