package lab6;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/shoppingcart")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		FoodEntriesDAO dao = new FoodEntriesDAO();

		FoodEntries toAdd = dao.get(id).get();

		List<FoodEntries> foodCart = (List<FoodEntries>) getServletContext().getAttribute("foodCart");

		foodCart.add(toAdd);


		request.setAttribute("foodCart", foodCart);

		response.sendRedirect("/jdbc/shoppingcart.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
