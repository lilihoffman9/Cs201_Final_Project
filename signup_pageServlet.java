package ningyues_CSCI201_Final_Project;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.google.gson.Gson;

@WebServlet("/signup_pageServlet")
public class signup_pageServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	// Constructor
	public signup_pageServlet() {
		super();
	}
	
	
	// Code to pull information from log in page
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    PrintWriter pw = response.getWriter();
	    Gson gson = new Gson();
	     
		String email = request.getParameter("email");
		String firstName = request.getParameter("first-name");
		String lastName = request.getParameter("last-name");
		String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    String passwordConfirmation = request.getParameter("password-confirmation");
		
		User currUser = new User(username, password, firstName, lastName, email);
		
		// TODO: Change to the type of response that the front end can use.
		if(verifyProperSignUp(username, password, passwordConfirmation, firstName, lastName, email)) {
			currUser.insertUser(username, password, firstName, lastName, email);
			response.sendRedirect("login_page.html");
		}
		else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            pw.write(gson.toJson("Please enter proper information"));
		}
		pw.flush();
	}

	
	protected boolean verifyProperSignUp(String username, String password, String passwordConfirmation, 
	        String firstName, String lastName, String email) {
	    
	    // Email validation with regex
	    boolean isValidEmail = email.matches("[^@]+@[^@]+\\.[^@]+");
	    if (!isValidEmail) {
	        return false;
	    }

	    boolean hasUpper = password.matches(".*[A-Z].*");
	    boolean hasLower = password.matches(".*[a-z].*");
	    boolean hasNumber = password.matches(".*\\d.*");
	    boolean hasSpecial = password.matches(".*[!@#$%^&*].*");

	    if (hasUpper && hasLower && hasNumber && hasSpecial) {
	    	return true;
	    }
	    else {
	    	return false;
	    }
	}

}


