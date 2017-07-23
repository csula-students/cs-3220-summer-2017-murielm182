package homework1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/shopping-cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init()
    {
    	List<FoodEntries> cartEntries=new ArrayList<>();
    	getServletContext().setAttribute("cartEntries", cartEntries);
    	
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		List<FoodEntries> food_entries=(List<FoodEntries>) getServletContext().getAttribute("food_entries");
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
	    
	    out.println("<main>");
	    out.println("<section class=\"main\">\r\n" + 
	    		"			<h1 class=\"h2\">Shopping Cart</h1>	\r\n" + 
	    		"			<table class=\"tabel3\" border=\"1\" bordercolor=\"#228B22\" cellspacing=\"0\" cellpadding=\"4\">\r\n" + 
	    		"				<thead>\r\n" + 
	    		"					<tr>\r\n" + 
	    		"                        <th>ID</th>\r\n " +
	    		"						<th>Name</th>\r\n" + 
	    		"						<th>Description</th>\r\n" + 
	    		"						<th>Food Image</th>\r\n" + 
	    		"						<th>Food Price</th>\r\n" + 
	    		"						<th>Action</th>\r\n" +
	    		"					</tr>\r\n" + 
	    		"				</thead>\r\n");
	    List<FoodEntries> cart_entries= (List<FoodEntries>) getServletContext().getAttribute("cart_entries"); 
	    for(FoodEntries entry:cart_entries)
	     out.println("<tbody>" +
	    "<tr>"+"<td>"+entry.getFoodID()+"</td>"+
	    		 "<td>"+entry.getFoodName()+"</td>"+
	    		 "<td>"+entry.getDescription()+"</td>"+
	    		 "<td><img src='"+entry.getFoodImageURL()+"'height='60' width='60'>"+"'</td >"+
	    		 "<td>"+entry.getFoodPrice()+"</td>"+
	    		 "<td><a href='shopping-cart/delete?id=" + entry.getFoodID() + "'>Delete</a>" + "</td>"+
	    		 "</tr>"+"</tbody>"	 );
	    
	    out.println("</table>");
	    out.println("<br>");
	    out.println("<a href='orders'>See Order Statuses</a>");
	    out.println("<footer><h5> @ Copyright Jacob,Muriel inc. All rights reserved.</h6></footer>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		List<Order> order_Entries=(List<Order>) getServletContext().getAttribute("order_Entries");
		List<FoodEntries> cartList = (List<FoodEntries>) getServletContext().getAttribute("cartList");

		for (FoodEntries entry : cartList) {

			order_Entries.add(new Order(order_Entries.size(), request.getParameter("name"),entry,new Date(),"IN_QUEUE"));
			getServletContext().setAttribute("orderEntries", order_Entries);
		}

		cartList.clear();
        
		out.println("<button onclick=\"location.href='orders'\">View Orders</button>");
		
	}

}
