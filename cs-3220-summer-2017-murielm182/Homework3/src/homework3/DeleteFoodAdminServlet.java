package homework3;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/admin/foods/delete")
public class DeleteFoodAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public DeleteFoodAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	int id=Integer.parseInt(request.getParameter("id"));
	List<FoodEntries> inventory=(List<FoodEntries>) getServletContext().getAttribute("inventory");
	int index=-1;
	for(int i=0;i<inventory.size();i++)
	{
		if(inventory.get(i).getFoodID()==id)
		{
			index=i;
		}
	}
	inventory.remove(index);
	getServletContext().setAttribute("foodlist", inventory);

	response.sendRedirect("http://localhost:8080/CS3220-HOMEWORK3/admin/foods");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
