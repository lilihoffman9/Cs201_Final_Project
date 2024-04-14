package jlee7162_201_FinalProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/************This class is for validating the User from the database ************/

public class UserJDBCConnector {
    private Connection connection;

    // Constructor to initialize the database connection
    public UserJDBCConnector() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Connect to the MySQL database
            String url = "jdbc:mysql://localhost:3306/registeredusers";
            String username = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, username, password);
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registered?user=root&password=root");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to authenticate a user
    public boolean authenticate(String username, String password) {
        try {
            // Prepare SQL query to check if the user exists
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            
            // Execute the query
            ResultSet resultSet = statement.executeQuery();
            
            // If the query returns any rows, the user is valid
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // If no rows returned or an exception occurred, user is not valid
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
        UserJDBCConnector auth = new UserJDBCConnector();
        boolean isValidUser = auth.authenticate("janicelee", "cs201");
        if (isValidUser) {
            System.out.println("User authenticated successfully.");
        } else {
            System.out.println("Invalid username or password.");
        }
        auth.closeConnection();
    }
}
