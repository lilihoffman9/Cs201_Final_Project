package ningyues_CSCI201_Final_Project;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	// Constructor
	public LogInServlet() {
		super();
	}
	
	
	// Code to pull information from log in page
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String username = request.getParameter("username");
	    String password = request.getParameter("password");
		
//		User currUser = new User(username, password);
		
		// TODO: Change to the type of response that the front end can use.
		//pw.print(currUser.authenticate(username, password));
	    if (username != null) {
            pw.println("<h1>Hello, " + username + "</h1>");
        } else {
            pw.println("<h1>Hello</h1>");
        }
        pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
