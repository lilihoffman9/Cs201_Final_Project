
import java.util.List;

public class User {
	private String userID; // reference to the userID's events in database
	private String username;
	private String password;
	private String name;
	private List<Event> registeredEvents;
	
	public User(String username, String userID) {
		this.username = username;
		this.userID = userID;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEvents() {
		//go through the List of events and print out 
		return null;
	}
	
	public Boolean authenticate() {
		//check for user is valid?
		
		return false;
	}

}