
import java.util.List;
//this is the User class that stores the user's information (username, password, and registeredEvents) 

public class User {
	private String userID; // reference to the userID's events in database
	private String username;
	private String password;
	private String name;
	private List<Integer> registeredEvents; // store EventID (example: 1-10) and when want to access do by query request

	
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
	public void addEvents(){
		//add eventID to registeredEvents
		//insert event to event Database?
	}
	
	public Boolean authenticate() {
		//check for user is valid?
		
		return false;
	}

}
