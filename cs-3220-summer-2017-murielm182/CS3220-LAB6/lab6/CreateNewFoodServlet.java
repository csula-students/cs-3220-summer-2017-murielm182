package lab6;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = { "/createfood" })
public class CreateNewFoodServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jdbc/create-food.jsp")
        .forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
        String description = request.getParameter("description");
        String image = request.getParameter("imageURL");
        String price = request.getParameter("price");
        
        FoodEntries newFood = new FoodEntries(-1,name, image,description,Double.parseDouble(price));

        FoodEntriesDAO dao = new FoodEntriesDAO();
        dao.add(newFood);
        response.sendRedirect(request.getContextPath() + "/InventoryServlet");
	}

}