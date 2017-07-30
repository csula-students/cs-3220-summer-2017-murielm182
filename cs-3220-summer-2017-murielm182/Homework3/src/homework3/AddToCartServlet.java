package homework3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/foods/addtocart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public void init()
	{
		List<FoodEntries> cartEntry=new ArrayList<>();
		getServletContext().setAttribute("cartEntry", cartEntry);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id=Integer.parseInt(request.getParameter("id"));
		List<FoodEntries> entries = (List<FoodEntries>) getServletContext().getAttribute("inventory");
		FoodEntries leEntry=null;
		for(FoodEntries ent:entries)
		{
			if(ent.getFoodID()==id)
			{
				leEntry=ent;
			}
		}
		
		List<FoodEntries> cartEntry=(List<FoodEntries>) getServletContext().getAttribute("cartEntry");
		cartEntry.add(new FoodEntries(id,leEntry.getFoodName(),leEntry.getDescription(), leEntry.getFoodImageURL(),leEntry.getFoodPrice()));
		getServletContext().setAttribute("cartEntries", cartEntry);
		//request.getRequestDispatcher("/cart.jsp").forward(request, response);	
		response.sendRedirect("http://localhost:8080/CS3220-HOMEWORK3/cart.jsp");
	}

}
