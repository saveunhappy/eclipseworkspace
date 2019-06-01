package car;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.userDao;


public class Book_data extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/***************************************
		 * 
		 * 
		 * 为商品详情页处理数据
		 * 
		 */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String book_id = request.getParameter("book_id");	//获得所选书籍ID
		userDao dao = new userDao();
		book new_book = new book();
		new_book = dao.get_Book(book_id);
		
		Writer out = response.getWriter();
		out.write(new_book.getBook_name());
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
