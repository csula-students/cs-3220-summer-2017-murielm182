package lab6;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/orderstatusadmin")
public class OrderStatusAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public OrderStatusAdminServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrdersDAO dao=new OrdersDAO();
		request.setAttribute("orders", dao.list());
		request.getRequestDispatcher("jdbc/order_statusesA.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
