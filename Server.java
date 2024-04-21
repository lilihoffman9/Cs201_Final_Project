import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;


public class Server extends Thread{
    private int port;
    private EventParser eventParser;
    private Map userData;   //Should this be a map???
	private HashMap dateAndEvent;
    private HashMap locAndEvent;
    private static PrintWriter pw;
	
	public Server(int port, String hostname) {
		try {
			ServerSocket serverSocket = new ServerSocket(port);
		} catch (IOException ioe) {
			System.out.println("ioe in ServerThread constructor: " + ioe.getMessage());
		}
	}

    //takes in name of an event we are searching for and returns the name of the associated event
    public Event getEvent(String name){
    	return null;
    }

    //takes in location of an event we are searching by and returns the name of the associated event
    //How to account for multiple events???
    public Event getEventByLocation(String loc){
        return null;
    }

    //takes in date of an event we are searching by and returns the name of the associated event
    //How to account for multiple events???
    public Event getEventByDate(String date){
        return null;
    }
	
    public String getUser(String k){
	return null;
     }

	public void sendMessage(String message) {
		pw.println(message);
		pw.flush();
	}
    
	public void run() {
		
	}
	
	public static void main(String[] args) throws ParseException, IOException{

	}
}
