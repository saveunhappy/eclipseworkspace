package car;

import java.io.IOException;
import java.util.HashMap;

import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Addcar extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String book_id = request.getParameter("book_id");	//获得所选书籍ID
		String numberString = request.getParameter("number"); 	//获取所选书籍数量；
		int book_number = Integer.parseInt(numberString); //将数量转为数值类型；
		HttpSession session = request.getSession();
		book new_book = (book)session.getAttribute(book_id);//获取在详情页临时存储在session中的book对象；
		new_book.setBook_number(book_number);	//将所选书籍数量存入书籍对象；
		
		Map map_car = (Map)session.getAttribute("map_car");
		if(map_car == null) {			//如果还创建购物车对象则创建购物车Map对象
			map_car = new HashMap();
			map_car.put(book_id, new_book);//将书籍对象加入购物车，对应键为其书籍id；
			session.setAttribute("map_car", map_car);//将购物车存入session;
			//重定向到购物车jsp
			response.sendRedirect("car.jsp");
		}else {
		/**********购物车存在start********/
			
			if(map_car.containsKey(book_id)) {	//判断购物车是否已存在该对象；若存在，新旧书籍对象所选数量相见存入购物车；
				book old_book = (book)map_car.get(book_id);
				int n = old_book.getBook_Number() + new_book.getBook_Number();
				old_book.setBook_number(n);
				//重定向到购物车jsp
				response.sendRedirect("car.jsp");	
			}else {
				map_car.put(book_id, new_book);//将书籍对象加入购物车，对应键为其书籍id；
				session.setAttribute("map_car", map_car);//将购物车存入session;
				//重定向到购物车jsp
				response.sendRedirect("car.jsp");
				
			}		
			
			
		/**********购物车存在end********/
		}
		
	
		
		
		
		/*************************连接数据库获得书籍信息start****************************/
		
		
		/*************************连接数据库获得书籍信息end*****************************/
		
		/************************将书籍添加到购物车start********************************/
		
		/************************将书籍添加到购物车end**********************************/
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
