package homework3;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deletefromcart")
public class DeleteFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<FoodEntries> cartEntry = (List<FoodEntries>) getServletContext().getAttribute("cartEntry");
		
		int index = -1;
		for (int i = 0; i < cartEntry.size(); i ++) {
			if (cartEntry.get(i).getFoodID() == id) {
				index = i;
			}
		}
		cartEntry.remove(index);
		getServletContext().setAttribute("cartEntry", cartEntry);

		response.sendRedirect("setcart");
	}
	}

