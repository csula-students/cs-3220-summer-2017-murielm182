package lab6;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editfood")
public class EditFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditFoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		FoodEntriesDAO dao=new FoodEntriesDAO();
		FoodEntries toEdit=dao.get(id).get();
		
		request.setAttribute("toEdit", toEdit);
		
		request.getRequestDispatcher("/jdbc/editfood.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String name = request.getParameter("name");
        String description = request.getParameter("description");
        String image = request.getParameter("imageURL");
        String price = request.getParameter("price");
        
        FoodEntries update = new FoodEntries(Integer.parseInt(id),name, image,description,Double.parseDouble(price));
        FoodEntriesDAO dao=new FoodEntriesDAO();
        dao.update(update);
        
        response.sendRedirect(request.getContextPath() + "/InventoryServlet");
		
		
		
	
}

		
}

