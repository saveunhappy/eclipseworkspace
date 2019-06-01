package car;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Car_rm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String book_id = request.getParameter("book_id");
		HttpSession session = request.getSession();
		Map map_car = (Map)session.getAttribute("map_car");
		session.removeAttribute("map_car");
		map_car.remove(book_id);
		session.setAttribute("map_car", map_car);
		response.sendRedirect("car.jsp");
		/*Iterator entries = map_car.entrySet().iterator(); 
		while (entries.hasNext()) { 
			  Map.Entry entry = (Map.Entry) entries.next(); 
			  String key = (String)entry.getKey(); 
			  System.out.print(key);
			//  book a = (book)entry.getValue();
		}*/
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
