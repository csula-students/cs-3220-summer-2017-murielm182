package lab04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/orders")
public class EditOrderStatusesAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public EditOrderStatusesAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init()
    {
    	List<Order> orderEntries=new ArrayList<>();
    	FoodEntries newitem=new FoodEntries(6,"Green Ozone",9.99);
    	List<FoodEntries> foodlist=new ArrayList<>();
    	foodlist.add(newitem);
    	orderEntries.add(new Order(0,foodlist,"Martha","COMPLETED",new Date()));
    	getServletContext().setAttribute("orderEntries", orderEntries);
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Order> orderEntries = (List<Order>) getServletContext().getAttribute("orderEntries");
		request.setAttribute("orderEntries", orderEntries);
		request.getRequestDispatcher("../WEB-INF/admin/order-statuses.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		
	}

}
