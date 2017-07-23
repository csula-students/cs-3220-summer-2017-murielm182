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

@WebServlet("/admin/orders")
public class OrderStatusAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public void init()
    {
    	List<Order> order_Entries=new ArrayList<>();
    	getServletContext().setAttribute("order_Entries", order_Entries);
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		List<FoodEntries> cart_entries = (List<FoodEntries>) getServletContext().getAttribute("cart_entries");
		out.println("<head>");
	    out.println("<title>Order Status for Admin</title>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<header>");
	    out.println("<h1 class=\"heading\"> Tea House<h1>\r\n" + 
	   
	    		"	</header>\r\n");
	    out.println("</header>");
	    
	    out.println("<main>");
	    out.println("<section class=\"main\">\r\n" + 
	    		"			<h1 class=\"h2\">Order Statues</h1>	\r\n");
	          out.println("<table border='2'>"+ 
	    		 
	    		"				<thead>\r\n" + 
	    		"					<tr>\r\n" + 
	    		"                        <th>ID</th>\r\n " +
	    		"						<th>Date</th>\r\n" + 
	    		"						<th>Item</th>\r\n" + 
	    		"						<th>Customer Name</th>\r\n" + 
	    		"						<th>Status</th>\r\n" + 
	    		"                       <th></th>\r\n"+
	    		"					</tr>\r\n" + 
	    		"				</thead>\r\n");
	    List<Order> order_Entries= (List<Order>) getServletContext().getAttribute("order_Entries"); 
	    for(Order od:order_Entries)
	     out.println("<tbody>" +
	    "<tr>"+"<td>"+od.getID()+"</td>"+
	    		 "<td>"+od.getDate()+"</td>"+
	    		 "<td>"+od.getFood().getFoodName()+"</td>"+
	    		 "<td>"+od.getName()+"</td>"+
	    		 "<td>"+od.getStatuses()+"</td>"+
	    		 "<td><a href='../admin/order/?id="+od.getID()+"'>Edit</a>"+"</td>"+"</tr>"+"</tbody>"	 );
	    
	    
	    		 
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//List<FoodItemEntry> entries_cart = (List<FoodItemEntry>) getServletContext().getAttribute("entries_cart");

	}

}
