package ningyues_CSCI201_Final_Project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.google.gson.Gson;

@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	// Constructor
	public LogInServlet() {
		super();
	}
	
	// Code to pull information from log in page
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        Gson gson = new Gson();
        
        String rawData = request.getReader().lines().collect(Collectors.joining());
        System.out.println("Raw JSON Received: " + rawData);
        User user = new Gson().fromJson(rawData, User.class);

        System.out.println("Content Type: " + request.getContentType());

        
		String username = user.getUsername();
		String password = user.getPassword();
        
		System.out.println(username + " " + password);
		
        if (username == null || password == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            pw.write(gson.toJson("User info missing"));
        } 
        else {
        	UserJDBCConnector auth = new UserJDBCConnector();

            if (!auth.authenticate(username, password)) {
//            	System.out.println("Invalid login Credentials");
            	response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                pw.write(gson.toJson("Invalid login credentials"));
            } 
            else { // successfully login
//            	System.out.println("successfully login");
            	response.setStatus(HttpServletResponse.SC_OK);
            	
            	UserJDBCConnector auth2 = new UserJDBCConnector();
            	User curUser = auth2.getUser(username, password);
//            	System.out.println(curUser.getUsername());
            	String userJson = gson.toJson(curUser);
//            	System.out.println(userJson);
    	        pw.write(userJson);
            }
        }
        pw.flush();
	}

}
