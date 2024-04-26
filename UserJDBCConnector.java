package ningyues_CSCI201_Final_Project;

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
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Connect to the MySQL database
            String url = "jdbc:mysql://localhost:3306/finalproject201";
            String username = "root";
            String password = "Nora_20030930";
            connection = DriverManager.getConnection(url, username, password);
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registered?user=root&password=root");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to authenticate a user
    public boolean authenticate(String username, String password) {
    	PreparedStatement statement = null;
    	ResultSet resultSet = null;
        try {
            // Prepare SQL query to check if the user exists
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            
            // Execute the query
            resultSet = statement.executeQuery();
            
            // If the query returns any rows, the user is valid
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	try {
        		if (statement != null) {
        			statement.close();
        		}
        		if (resultSet!= null) {
        			resultSet.close();
        		}
        		if (connection != null) {
        			 connection.close();
        		}
        	} catch (SQLException sqle) {
        		System.out.println("sqle: " + sqle.getMessage());
        	}
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

    // Method to authenticate a user and get this user's info
 // Method to authenticate a user and get this user's info
    public User getUser(String username, String password) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Prepare SQL query to check if the user exists
            String sql = "SELECT username, password, firstName, lastName, email FROM users WHERE username = ? AND password = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            
            // Execute the query
            resultSet = statement.executeQuery();
            
            // If the query returns any rows, the user is valid
            if (resultSet.next()) {
            	//int userID = resultSet.getInt("userID");           
            	String retrievedUsername = resultSet.getString("username");
                String retrievedPassword = resultSet.getString("password");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String email = resultSet.getString("email");
                
                // Create a new User object with the retrieved details
                User curUser = new User(retrievedUsername, retrievedPassword, firstName, lastName, email);
                System.out.println("in JDBC: " + username + " " + email);
                return curUser;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close all connections to avoid memory leaks
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null; 
    }

}
