/*
This class is to: 
1. Insert an Event Registration into the SQL database ]
2. Allow users to register for an event
3. Interactions with Registrations table
*/


package ningyues_CSCI201_Final_Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventRegistrationJDBCConnector {
    private Connection connection;

    // ctr to initialize the database connection
    public EventRegistrationJDBCConnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/finalproject201";  // your database name 
            String username = "root"; 
            String password = "Nora_20030930";  
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean insertRegistration(int userId, int eventId) {
        if (!isAlreadyRegistered(userId, eventId)) {
            String sql = "INSERT INTO Registrations (userID, eventID) VALUES (?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, userId);
                stmt.setInt(2, eventId);
                int affectedRows = stmt.executeUpdate();
                return affectedRows > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("User is already registered for this event.");
        }
        return false;
    }

    // Check if the user has already registered for this event
    private boolean isAlreadyRegistered(int userId, int eventId) {
        String sql = "SELECT COUNT(*) FROM Registrations WHERE userID = ? AND eventID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, eventId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    // Close the database connection
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   // Method to retrieve registration details for a specific user
    public List<String> getUserRegistrations(int userId) {
        List<String> registrations = new ArrayList<>();
        String sql = "SELECT Events.eventName, Events.date, Events.location, Events.description " +
                     "FROM Registrations JOIN Events ON Registrations.eventID = Events.eventID " +
                     "WHERE Registrations.userID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String eventDetails = "Event ID: " + rs.getInt("eventID") +
                					  "Event Name: " + rs.getString("eventName") +
                                      ", Date: " + rs.getDate("date") +
                                      ", Location: " + rs.getString("location") +
                                      ", Description: " + rs.getString("description");
                registrations.add(eventDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrations;
    }
    
    public LocalDateTime getRegistrationTime(int userId, int eventId) {
        String sql = "SELECT registrationTime FROM Registrations WHERE userID = ? AND eventID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, eventId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getTimestamp("registrationTime").toLocalDateTime();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }

    public int getRegistrationID(int userId, int eventId) {
        String sql = "SELECT registration FROM Registrations WHERE userID = ? AND eventID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, eventId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("registrationID");  
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; 
    }
    
    // for testing the connector
    public static void main(String[] args) {
        EventRegistrationJDBCConnector auth = new EventRegistrationJDBCConnector();
        // A registration with userID=1 and eventID=1
        if (auth.insertRegistration(1, 1)) {
        	 System.out.println("The user was registered to the event successfully.");
        } else {
            System.out.println("There was a problem registering the user to the event.");
        }
        List<String> registrations = auth.getUserRegistrations(1);
        for (String registration : registrations) {
            System.out.println(registration);
        }

        auth.closeConnection();
    }
}
