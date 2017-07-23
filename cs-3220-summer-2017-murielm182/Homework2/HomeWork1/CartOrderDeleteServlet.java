package homework1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/shopping-cart/delete")
public class CartOrderDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		List<FoodEntries> cart_entries = (List<FoodEntries>) getServletContext().getAttribute("cart_entries");
		int index = -1;
		for (int i = 0; i < cart_entries.size(); i++) {
			if (cart_entries.get(i).getFoodID() == id) {
				index = i;
			}
		}
		cart_entries.remove(index);
		getServletContext().setAttribute("cart_entries", cart_entries);
		out.println("<h5>Item Removed</h5>");
		out.println("<a href='../shopping-cart'>back to Shopping Cart</a>");
		
		out.println("<footer><h5> @ Copyright Jacob,Muriel inc. All rights reserved.</h6></footer>");

}
}
