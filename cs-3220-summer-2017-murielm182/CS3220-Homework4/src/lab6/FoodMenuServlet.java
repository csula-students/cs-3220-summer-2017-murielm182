package lab6;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/menu")
public class FoodMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FoodEntriesDAO dao=new FoodEntriesDAO();
		request.setAttribute("list", dao.list());
		System.out.println(dao.list());
		request.getRequestDispatcher("/jdbc/menu.jsp").forward(request, response);
		
		
		
	}

	

}
