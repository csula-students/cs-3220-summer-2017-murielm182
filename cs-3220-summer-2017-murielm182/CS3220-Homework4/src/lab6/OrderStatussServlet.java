package lab6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/orderstatus")
public class OrderStatussServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   public void init()
   {
	   List<Orders> orders=new ArrayList<>();
	   getServletContext().setAttribute("orders", orders);
	   
   }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	OrdersDAO dao=new OrdersDAO();
	request.setAttribute("orders", dao.list());
	request.getRequestDispatcher("/jdbc/orders.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
