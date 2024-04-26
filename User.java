package ningyues_CSCI201_Final_Project;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//this is the User class that stores the user's information (username, password, and registeredEvents) 

public class User {
	private String userID; // reference to the userID's events in database
	private String username;
	private String password;
	private List<Integer> registeredEvents; //can store EventID (1-10) and when want to access do by query request
	private String firstName;
	private String lastName;
	private String email;
	private UserJDBCConnector userValidate = new UserJDBCConnector();  //this is for validating user
	private Connection connection; //this is for insertingUser
	private RegisterJDBCConnector register = new RegisterJDBCConnector();
	
	//first constructor is to registerUser
	public User(String username, String password, String firstName, String lastName, String email) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	//second constructor is for User validation 
	public User(String username, String password ) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public String getFirstName(String firstName){
	    return firstName;
	}
	
	public String getLastName(String lastName){
	    return lastName;
	}

	
	public String getEvents() {
		//go through the List of events and print out 
		return null;
	}
	
	public void addEvents(){
		//add eventID to registeredEvents
		//insert event to event Database?
	}
	
	//validating user here calls the function in UserJDBCConnection class
	public Boolean authenticate(String username, String password) {
		return userValidate.authenticate(username, password);
	}
	
	//inserting user here calls the function in RegisterJDBConnector class
	public void insertUser(String username, String password, String firstName, String lastName, String email) {
		register.insertUserToSQL(username, password, firstName, lastName, email);
	}

}
