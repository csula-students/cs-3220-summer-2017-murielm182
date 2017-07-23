package lab04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/foods/editorderstatus")
public class EditOrderStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public EditOrderStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    PrintWriter out=response.getWriter();
	    int id=Integer.parseInt(request.getParameter("id"));
	    List<Order> orderEntries = (List<Order>) getServletContext().getAttribute("orderEntries");
	    Order leEntry=null;
	    for(Order od:orderEntries)
	    {
	    	if(od.getID()==id)
	    	{
	    		leEntry=od;
	    	}
	    }
	    request.setAttribute("orderEntries", orderEntries);
		request.getRequestDispatcher("../../WEB-INF/admin/edit-order.jsp")
			.forward(request, response);
	    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		int id=Integer.parseInt(request.getParameter("id"));
		List<Order> orderEntries = (List<Order>) getServletContext().getAttribute("orderEntries");
		int index=-1;
		Order leEntry=null;
		for(int i=0;i<orderEntries.size();i++)
		{
			if(orderEntries.get(i).getID()==id)
			{
				leEntry=orderEntries.get(i);
				index=i;
			}
		}
		int newid=leEntry.getID();
		
		
		orderEntries.add(index,
				new Order(newid,leEntry.getFoodList(),leEntry.getCustomerName(),leEntry.getStatus(),leEntry.getDate()));
		getServletContext().setAttribute("orderEntries", orderEntries);

		response.sendRedirect("/admin/orders");
		
	}

}
