package homework3;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/foods")
public class InventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {
		List<FoodEntries> inventory = new ArrayList<>();
		inventory.add(new FoodEntries(0, "The Vanessa","Cherries and Berry","http://cdn.crownmediadev.com/f1/13/bffb4c2b4786bc96dcd333de2f9b/home-family-georgia-strawberry-peach-tea.jpg",10.99));
		getServletContext().setAttribute("inventory", inventory);
	}
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<FoodEntries> inventory = (List<FoodEntries>) getServletContext().getAttribute("inventory");
		request.setAttribute("inventory", inventory);
		request.getRequestDispatcher("../WEB-INF/admin/inventory.jsp").forward(request, response);
	}

}
