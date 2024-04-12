package pdpremku_CSCI201_Assignment4;

import java.util.Vector;

public class Client {
	int portNumber;
	String hostName;
	String userName;
	Vector<Event> registeredEvents;
	User Userdata;
	
	public Client(int portNum, String host, String user, Vector<Event> regEvents, User userData)
	{
		portNumber = portNum;
		hostName = host;
		userName = user;
		registeredEvents = regEvents;
		Userdata = userData;
	}
	
	Vector<Event> getEvents()
	{
		return registeredEvents;
	}
	
	User getUserData()
	{
		return Userdata;
	}
	
	void printEvents()
	{
		String temp = "";
		for(int i = 0; i < registeredEvents.size(); i++)
		{
			temp += "Name: " + registeredEvents.get(i).getName() + "\n";
			temp += "Location: " + registeredEvents.get(i).getLocation() + "\n";
			temp += "Date: " + registeredEvents.get(i).getDate() + "\n";
			temp += "Details: " + registeredEvents.get(i).getDetails() + "\n";
			System.out.println(temp);
			temp = "";
		}
	}

}
