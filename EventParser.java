import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventParser {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/events";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";

    
    // Search events by date
    public List<Event> searchEventsByDate(String date) {
        return searchEvents("eventDate", date);
    }

    // Search events by location
    public List<Event> searchEventsByLocation(String location) {
        return searchEvents("location", location);
    }

    // Search events by name
    public List<Event> searchEventsByName(String eventName) {
        return searchEvents("eventName", eventName);
    }

    // Generic search method
    private List<Event> searchEvents(String fieldName, String value) {
        List<Event> events = new ArrayList<>();
        String query = "SELECT eventName, eventDate, location, description FROM Events WHERE " + fieldName + " = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setString(1, value);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                events.add(new Event(
                    rs.getString("eventName"),
                    rs.getString("eventDate"),
                    rs.getString("location"),
                    rs.getString("description")
                ));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error accessing the database: " + e.getMessage());
        }
        return events;
    }
}