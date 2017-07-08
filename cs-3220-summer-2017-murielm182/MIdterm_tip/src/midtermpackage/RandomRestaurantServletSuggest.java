package midtermpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RandomRestaurantServletSuggest")
public class RandomRestaurantServletSuggest extends HttpServlet {
	private static final long serialVersionUID = 1L;
  //mockup page1 where it 
    public RandomRestaurantServletSuggest() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init()
    {
    	String[] url=new String[22];
    	int[] id=new int[22];
    	String[] name=new String[22];
    	int[] designRatings=new int[22];
    	int[] tasteRatings=new int[22];
    	
    	
    	List<Restaurant> entries=new ArrayList<>();
    	for(int i=1;i<=22;i++)
    	{
    		entries.add(new Restaurant(i,"Students's"+i+"Restaurant","http://cs3.calstatela.edu:8080/cs3220xstu0"+i+"/menu", tasteRatings, tasteRatings));
    		
    	}
    }
    
    public Restaurant getRandomRestaurant(List<Restaurant> list) {
    	return list.get(new Random().nextInt(list.size()));
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		//out.println("<head>");
		out.println("<h1>What's for Lunch?</h1>");
		out.println("<form method=\"post\">");
		out.println("<table border=1>");
		out.println("<tr>"+"<th> </th>"+"</tr>");
		out.println("<tr>"+);
		
				
				
				
				
				
				
				
		out.println("</form>");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
