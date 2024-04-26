import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.google.gson.Gson;

@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	Gson gson;
	
	// Constructor
	public LogInServlet() {
		super();
	}
	
	// Code to pull information from log in page
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        User user = new Gson().fromJson(request.getReader(), User.class);
		String username = user.getUsername();
		String password = user.getPassword();
        
        if (username == null || password == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            pw.write(gson.toJson("User info missing"));
        } 
        else {
        	UserJDBCConnector auth = new UserJDBCConnector();

            if (auth.authenticate(username, password)) {
                pw.write(gson.toJson("Invalid login credentials"));
            } 
            else { // successfully login
            	User curUser = auth.getUser(username, password);
            	String userJson = gson.toJson(curUser);
    	        pw.write(userJson);
            }
        }
        pw.flush();
	}

}
