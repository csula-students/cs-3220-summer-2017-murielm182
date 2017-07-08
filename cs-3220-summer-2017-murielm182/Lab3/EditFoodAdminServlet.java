package lab3package;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditFoodAdminServlet
 */
@WebServlet("/FoodMenuServlet/edit")
public class EditFoodAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public EditFoodAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int id=Integer.parseInt(request.getParameter("id"));
		List<FoodEntries> entries=(List<FoodEntries>) getServletContext().getAttribute("entries");
		FoodEntries leEntry=null;
		for(FoodEntries ent:entries)
		{
			if(ent.getFoodID()==id)
			{
				leEntry=ent;
			}
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Edit Food</h1>");
		out.println("<form method=\"post\">");
		out.println("Food Name: <input name='foodname' type='text' value='" + leEntry.getFoodName() + "'/></br>");
		out.println("Description:<textarea name='description' >"+leEntry.getDescription()+"</textarea></br>");
		out.println("Food image URL: <input name='foodimageURL' type='text' value='" + leEntry.getFoodImageURL() + "'/></br>");
		out.println("Food Price: <input name='foodprice' type='number' value='" + leEntry.foodprice + "'/></br>");
		out.println("<button>Edit</button>");
		out.println("</form>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int id = Integer.parseInt(request.getParameter("id"));
		List<FoodEntries> entries = (List<FoodEntries>) getServletContext().getAttribute("entries");
		FoodEntries leEntry = null;
		int index = -1;
		for (int i = 0; i < entries.size(); i ++) {
			if (entries.get(i).getFoodID() == id) {
				leEntry = entries.get(i);
				index = i;
			}
		}
		entries.set(index, new FoodEntries(
			leEntry.getFoodID(),
			request.getParameter("foodname"),
			request.getParameter("description"),
			request.getParameter("foodimageURL"),
			Integer.parseInt(request.getParameter("foodprice")
		)));
		getServletContext().setAttribute("entries", entries);

		response.sendRedirect("../FoodMenuServlet");
	}

}
