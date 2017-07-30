package homework3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/setcart")
public class SetCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init() {
		List<FoodEntries> cartEntry = new ArrayList<>();
		getServletContext().setAttribute("cartEntry", cartEntry);
	}

	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<FoodEntries> cartEntry = (List<FoodEntries>) getServletContext().getAttribute("cartEntry");
		request.setAttribute("cartEntry", cartEntry);
		
		request.getRequestDispatcher("/cart.jsp")
			.forward(request, response);
	}

}
