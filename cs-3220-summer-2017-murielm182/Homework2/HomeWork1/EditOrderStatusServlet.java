package homework1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/order")
public class EditOrderStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public EditOrderStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
       int id=Integer.parseInt(request.getParameter("id"));
       List<Order> orderEntries=(List<Order>) getServletContext().getAttribute("orderEntries");
       Order leEntry=null;
       for (Order entries:orderEntries)
       {
    	   if(entries.getID()==id)
    	   {
    		   leEntry=entries;
    	   }
       }
       response.setContentType("text/html");
       PrintWriter out=response.getWriter();
       out.println("<h2>Edit the Order</h2>");
       out.println("<form method=\"post\">");
       out.println("<select id =\"status\" name = \"status\">");
		out.println("<option value =\"IN_QUEUE\" selected>" + leEntry.getInQueueStatus()+ "</option>");
		out.println("<option value =\"IN_PROGRESS\">" + leEntry.getInProgressStatus()+ "</option>");
		out.println("<option value =\"COMPLETED\">" + leEntry.getCompletedStatus() + "</option>");
		out.println("</select>");
		out.println("<button>Edit</button>");
		out.println("</form>");
       
       
       
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
	       List<Order> orderEntries=(List<Order>) getServletContext().getAttribute("orderEntries");
	       Order leEntry=null;
	       int index=-1;
	       for(int i=0; i<orderEntries.size();i++)
	       {
	    	   if(orderEntries.get(i).getID()==id)
	    	   {
	    		   leEntry=orderEntries.get(i);
	    		   index=i;
	    	   }
	       }
	       leEntry.setStatus(request.getParameter("status").toString());
	       orderEntries.set(index, new Order(leEntry.getID(),leEntry.getName(),leEntry.getFood(),leEntry.getDate(),leEntry.getStatuses()));   
	       getServletContext().setAttribute("orderEntries", orderEntries); 
	       
	       out.println("<button onclick=\"location.href='../../admin/orders'\">Order Status -Admin</button>");
	       
	       out.println("<footer><h5> @ Copyright Jacob,Muriel inc. All rights reserved.</h6></footer>");
	       
		
		
		
		
	}

}
