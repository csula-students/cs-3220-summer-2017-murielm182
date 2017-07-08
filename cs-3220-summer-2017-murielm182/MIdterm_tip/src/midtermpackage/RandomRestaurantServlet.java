package midtermpackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RandomRestaurantServlet")
public class RandomRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public RandomRestaurantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
//page1
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>What's for Lunch?</h1>");
		out.println("<form method=\"post\">");
		out.println("<a href='www.google.com'>Feeling Lucky</a>");
		out.println("&nbsp&nbsp&nbsp&nbsp");
		out.println("<a href='www.youtube.com'>See the List</a>");
		out.println("</form>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
