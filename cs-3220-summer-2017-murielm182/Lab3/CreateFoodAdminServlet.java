package lab3package;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FoodMenuServlet/create")
public class CreateFoodAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public CreateFoodAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<h1>Create Food</h1>");
		out.println("<form method=\"post\">");
		out.println("Food Name: <input name='foodname' type='text'/></br>");
		out.println("Description:<textarea name='description' ></textarea></br>");
		out.println("Food image URL: <input name='foodimageURL' type='text'/></br>");
		out.println("Food Price: <input name='foodprice' type='number'/></br>");
		out.println("<button>Add Food</button>");
		out.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		List<FoodEntries> entries = (List<FoodEntries>) getServletContext().getAttribute("entries");
		entries.add(new FoodEntries(entries.size(),request.getParameter("foodname"),request.getParameter("description"),request.getParameter("foodimageURL"),Integer.parseInt(request.getParameter("foodprice"))));
		getServletContext().setAttribute("entries", entries);
		PrintWriter out = response.getWriter();
		//out.println("<a href='/FoodMenuServlet'>back to Food Menu</a>");
		response.sendRedirect("../FoodMenuServlet");
	}

}
