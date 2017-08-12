package lab6;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/shoppingcart")
public class AddItemToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		FoodEntriesDAO dao = new FoodEntriesDAO();
		FoodEntries item_To_Add = dao.get(id).get();
		
		List<FoodEntries> cart = new ArrayList<FoodEntries>();
		PrintWriter out = response.getWriter();
		boolean item_in_cart = false;
		if (!cart.isEmpty()){
			for (FoodEntries item : cart) {
				if (item.getID() == item_To_Add.getID()) {
					item_in_cart = true;
					
				}
			}
		}
		if (item_in_cart == false) {
			cart.add(item_To_Add);
		}

		getServletContext().setAttribute("cart", cart);

		response.sendRedirect("shopping_cart");
}
		
		
}
		

	

	


