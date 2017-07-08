package lab3package;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/foodlist")
public class FoodMenuListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FoodMenuListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
       List<FoodEntries> entries = (List<FoodEntries>) getServletContext().getAttribute("entries");
		
		response.setContentType("text/html");
		out.println("<h1> Welcome to Tea House </h1>");
		out.println("<table border='2'>");
		for (FoodEntries entry : entries) {
			out.println("<tr>"  
					+"<td>" + entry.getFoodName() + "  </td>" 
					+ "<td>"+ entry.getDescription() + " </td>" 
					+ "<td>"+ entry.getFoodPrice() + " </td>" 
					+ "<td><img src='"+entry.getFoodImageURL()+"'height='60' width='60'>"+"'</td >"
					
		+"</tr>"

			);
		}
		out.println("</table>");
		
		
		
		
	    
		out.println("<footer><h5> @ Copyright Jacob,Muriel inc. All rights reserved.</h6></footer>");
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
