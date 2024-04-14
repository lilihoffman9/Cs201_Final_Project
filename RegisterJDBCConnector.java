

//*****This class is to insert the User into the SQL database ***********/


package jlee7162_201_FinalProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterJDBCConnector {
    private Connection connection;

    // Constructor to initialize the database connection
    public RegisterJDBCConnector() {
        try {
            // Load the MySQL JDBC driver
        	Class.forName("com.mysql.cj.jdbc.Driver");            
            // Connect to the MySQL database
            String url = "jdbc:mysql://localhost:3306/registeredusers";
            String username = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to insert a user to SQL databse
    public void insertUserToSQL(String username, String password, String firstName, String lastName) {
        try {
            // Prepare SQL query to insert a new user
            String sql = "INSERT INTO users (username, password, firstName, lastName) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, firstName);
            statement.setString(4, lastName);

            // Execute the query
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("User inserted successfully.");
            } else {
                System.out.println("Failed to insert user.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Close the database connection
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        RegisterJDBCConnector auth = new RegisterJDBCConnector();
        auth.insertUserToSQL("cs201", "finalproject4", "Papa", "Macro");
        auth.closeConnection();
    }
}
