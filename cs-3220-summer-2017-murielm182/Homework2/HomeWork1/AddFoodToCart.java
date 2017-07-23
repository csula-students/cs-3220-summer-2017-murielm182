package homework1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/foodmenu/add")
public class AddFoodToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		List<FoodEntries> food_entries = (List<FoodEntries>) getServletContext().getAttribute("food_entries");
		FoodEntries ent = null;
		for (FoodEntries entry : food_entries) {
			if (entry.getFoodID() == id) {
				ent = entry;
			}
		}
		List<FoodEntries> cart_entries = (List<FoodEntries>) getServletContext().getAttribute("food_entries");
		cart_entries.add(new FoodEntries(id, ent.getFoodName(), ent.getDescription(), ent.getFoodImageURL(),ent.getFoodPrice()));

		getServletContext().setAttribute("cart_entries", cart_entries);
		
		out.println("<button onclick=\"location.href='../foodlist'\">Back to Menu</button>");
		out.println("<br>");
		out.println("<button onclick=\"location.href='../shopping-cart'\">View my Cart</button>");
		
		out.println("<footer><h5> @ Copyright Jacob,Muriel inc. All rights reserved.</h6></footer>");

	}

	
}
