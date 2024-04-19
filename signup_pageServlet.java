import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/signup_pageServlet")
public class signup_pageServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	// Constructor
	public signup_pageServlet() {
		super();
	}
	
	
	// Code to pull information from log in page
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String email = request.getParameter("email");
		String firstName = request.getParameter("first-name");
		String lastName = request.getParameter("last-name");
		String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    String passwordConfirmation = request.getParameter("password-confirmation");
		
		User currUser = new User(username, password, firstName, lastName, email);
		
		// TODO: Change to the type of response that the front end can use.
		if(verifyProperSignUp(username, password, passwordConfirmation, firstName, lastName, email)) {
			pw.print(true);
			currUser.insertUser(username, password, firstName, lastName);
		}
		else {
			pw.print(false);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected boolean verifyProperSignUp(String username, String password, String passwordConfirnation, 
			String firstName, String lastName, String email) {
		
		boolean response = true;
		int atCounter = 0;
		
		// Verify email is in proper format by checking for '@', '.' and no spaces
		String dummyString = "";
		for(int i = 0; i < email.length(); i++) {
			if(email.charAt(i) == '@' || email.charAt(i) == '.') {
				dummyString += email.charAt(i);
			}
		}
		
		// Return false if either no '@' or '.' was found
		if(dummyString.length() < 2) {
			response = false;
		}
		
		// Parse to ensure there is an '@' followed by an '.'
		response = false;
		for(int i = 0; i < email.length() - 1; i++) {
			
			if(dummyString.charAt(i) == '@' && dummyString.charAt(i+1) == '.') {
				response = true;
			}
			// There shouldn't be more than one '@'
			if(dummyString.charAt(i) == '@') {
				atCounter ++;
			}
		}
		
		if(atCounter > 1) {
			response = false;
		}
		
		
		// Verify passwords match and meet requirements, see java unicode table for char values
		int intCount = 0;
		int lowerCaseCount = 0;
		int upperCaseCount = 0;
		int specialCharCount = 0;
		
		for(int i = 0; i < password.length(); i++) {
			if(password.charAt(i) >= 48 && password.charAt(i) < 58) {
				intCount++;
			}
			else if(password.charAt(i) >= 65 && password.charAt(i) < 91) {
				upperCaseCount++;
			}
			else if(password.charAt(i) >= 97 && password.charAt(i) < 122) {
				lowerCaseCount++;
			} //!, @, #, $, %, ^, &, *
			else if(password.charAt(i) == '!' || password.charAt(i) == '@' || password.charAt(i) == '#'
					|| password.charAt(i) == '$' || password.charAt(i) == '%' || password.charAt(i) == '^'
					|| password.charAt(i) == '&' || password.charAt(i) == '*') {
				specialCharCount++;
			}
		}
		

		if(intCount == 0|| lowerCaseCount  == 0|| upperCaseCount  == 0|| specialCharCount  == 0) {
			response = false;
		}
		
		if(!password.equals(passwordConfirnation)) {
			response = false;
		}
		
		// TODO: Create a way to verify whether it is a duplicate registration
		
		return response;
	}
}
