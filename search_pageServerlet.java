import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/search_pageServerlet")
public class search_pageServerlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	// Constructor
	public search_pageServerlet() {
		super();
	}
	
	
	// Code to pull information from log in page
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String searchBox = request.getParameter("search-box");
		
		// TODO: Change to the type of response that the front end can use.
		pw.print(searchBox);
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
