package homework3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/orders")
public class OrderStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {
		List<Order> orderEntries = new ArrayList<>();
		getServletContext().setAttribute("cartEntry", orderEntries);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		int id = Integer.parseInt(request.getParameter("id"));
		List<Order> orderEntry = (List<Order>) getServletContext().getAttribute("inventory");
		Order leEntry = null;
		int index = -1;
		for (int i = 0; i < orderEntry.size(); i++) {
			if (orderEntry.get(i).getID() == id) {
				leEntry = orderEntry.get(i);
				index = i;
			}
			
		}
		String status = request.getParameter("status");
		orderEntry.set(index, new Order(leEntry.getID(), leEntry.getFoodList(), leEntry.getCustomerName(), leEntry.getStatus()));
		getServletContext().setAttribute("orderEntry", orderEntry);
		
		request.getRequestDispatcher("orderstatus.jsp").forward(request, response);
	}

	
}
