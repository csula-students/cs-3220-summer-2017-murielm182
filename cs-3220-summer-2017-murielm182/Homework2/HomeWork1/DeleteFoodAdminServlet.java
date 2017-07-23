package homework1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adminfoodlist/delete")
public class DeleteFoodAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DeleteFoodAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int id = Integer.parseInt(request.getParameter("id"));
		List<FoodEntries> entries = (List<FoodEntries>) getServletContext().getAttribute("entries");
		int index = -1;
		for (int i = 0; i < entries.size(); i ++) {
			if (entries.get(i).getFoodID() == id) {
				index = i;
			}
		}
		entries.remove(index);
		getServletContext().setAttribute("entries", entries);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<a href='http://localhost:8080/CS3220-Summer-Lab3/FoodMenuServlet'>go back to FoodMenu</a>");
		
		out.println("<footer><h5> @ Copyright Jacob,Muriel inc. All rights reserved.</h6></footer>");
	}

	

}
