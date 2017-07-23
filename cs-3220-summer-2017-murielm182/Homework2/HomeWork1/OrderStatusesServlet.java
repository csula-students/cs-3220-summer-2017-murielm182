package homework1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/orders")
public class OrderStatusesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
public void init()
{
	List<Order> order_Entries=new ArrayList<>();
	getServletContext().setAttribute("order_Entries", order_Entries);
	
}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		List<FoodEntries> cart_entries = (List<FoodEntries>) getServletContext().getAttribute("cart_entries");
		out.println("<head>");
	    out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../app.css\">");
	    out.println("<title>Order Status for Admin</title>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<header>");
	    out.println("<h1 class=\"heading\"> Tea House<h1>\r\n" + 
	    		"			</h1>\r\n" + 
	    		"			\r\n" + 
	    		 
	    		"			\r\n" + 
	    		"		</section>\r\n" + 
	    		"\r\n" + 
	    		"	</header>\r\n" + 
	    		"\r\n" + 
	    		"");
	    out.println("</header>");
	    
	    List<Order> order_Entries = (List<Order>) getServletContext().getAttribute("order_Entries");
	    
	    out.println("<main>");
	    out.println("<section class=\"main\">\r\n" + 
	    		"			<h1 class=\"h2\">Order Statuses</h1>	\r\n"); 
	    		out.println("<table border='2'>"+ 
	    		"				<thead>\r\n" + 
	    		"					<tr>\r\n" + 
	    		"                        <th>ID</th>\r\n" +
	    		"						<th>Date</th>\r\n" + 
	    		"						<th>Item</th>\r\n" + 
	    		"						<th>Customer Name</th>\r\n" + 
	    		"						<th>Status</th>\r\n" ); 
	    		
	    for(Order od : order_Entries)
	    {
	    	out.println("<tbody>"+
		    		"					</tr>\r\n" + 
	    			"                     <td>"+od.getID()+"</td>"+
	    			"                     <td>"+od.getDate()+"</td>"+
	    			"                     <td>"+od.getFood().getFoodName()+"</td>"+
	    			"                     <td>"+od.getName()+"</td>"+
	    			"                     <td>"+od.getStatuses()+"</td>"+
		    		
		    		
		    		"					</tr>\r\n" + 
		    		
		    		"		</section>\r\n" + 
		    		"");
	    	
	    }
	    
	    out.println("</main>");
	    out.println("</body>");
	    
	    out.println("<a href='admin/orders'>Edit Order Admin</a>");
	    
	    
	    
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
