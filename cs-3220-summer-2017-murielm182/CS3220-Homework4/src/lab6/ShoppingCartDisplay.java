package lab6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/shopping_cart")
public class ShoppingCartDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public void init()
    {
    	List<FoodEntries> foodCart=new ArrayList<>();
    	getServletContext().setAttribute("shopping_cart", foodCart);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<FoodEntries> foodCart=(List<FoodEntries>) getServletContext().getAttribute("shopping_cart");
		request.setAttribute("foodCart",foodCart);
		request.getRequestDispatcher("/jdbc/shoppingcart.jsp").forward(request, response);
	}

	

}

