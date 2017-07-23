package homework1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/foodlist/create")
public class CreateFoodAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public CreateFoodAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<h1>Create Food</h1>");
		out.println("<form method=\"post\">");
		out.println("Food Name: <input name='foodname' type='text'/></br>");
		out.println("Description:<textarea name='description' ></textarea></br>");
		out.println("Food image URL: <input name='foodimageURL' type='text'/></br>");
		out.println("Food Price: <input name='foodprice' type='number' step='0.01'/></br>");
		out.println("<button>Add Food</button>");
		out.println("</form>");
		
		out.println("<footer><h5> @ Copyright Jacob,Muriel inc. All rights reserved.</h6></footer>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		List<FoodEntries> food_entries = (List<FoodEntries>) getServletContext().getAttribute("food_entries");
		food_entries.add(new FoodEntries(food_entries.size(),request.getParameter("foodname"),request.getParameter("description"),request.getParameter("foodimageURL"),Integer.parseInt(request.getParameter("foodprice"))));
		getServletContext().setAttribute("food_entries", food_entries);
		PrintWriter out = response.getWriter();
		response.sendRedirect("http://localhost:8080/CS-3220-Homework2/adminfoodlist");
	}

}
