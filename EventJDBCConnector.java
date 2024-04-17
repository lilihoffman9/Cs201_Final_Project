
/*
 * This class is to: 
 * 1. insert the Event into the SQL database
 * 2. TODO: fetch event info to support Event Class
*/


package ningyues_CSCI201_Final_Project;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventJDBCConnector {
    private Connection connection;

    // Constructor to initialize the database connection
    public EventJDBCConnector() {
        try {
            // Load the MySQL JDBC driver
        	Class.forName("com.mysql.cj.jdbc.Driver");            
            // Connect to the MySQL database
            String url = "jdbc:mysql://localhost:3306/finalproject201";
            String username = "root";
            String password = "Nora_20030930";
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to insert a user to SQL databse
    public void insertEventToSQL(String eventName, String location, String date, String description, String QRCodePath) {
        try {
            // Prepare SQL query to insert a new user
            String sql = "INSERT INTO events (eventName, location, date, description, QRCodePath) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, eventName);
            statement.setString(2, location);
            statement.setString(3, date);
            statement.setString(4, description);
            statement.setString(5, QRCodePath);

            // Execute the query
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Event inserted successfully.");
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
    
    public int getEventID(String eventName) {
        String sql = "SELECT eventID FROM Events WHERE eventName = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, eventName);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("eventID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    
    public static void main(String[] args) {
        EventJDBCConnector auth = new EventJDBCConnector();
        String eventName = "Tech Conference";
        String location = "Conference Hall";
        String date = "2024-05-20 09:00:00";  // Date format must be 'YYYY-MM-DD HH:MM:SS'
        String description = "Annual tech conference";
        String QRCodePath = "/path/to/qrcode.png";  // path to the QR code image
        auth.insertEventToSQL(eventName, location, date, description, QRCodePath);
        auth.closeConnection();
    }


}

