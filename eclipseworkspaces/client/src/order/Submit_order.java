package order;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.userDao;


public class Submit_order extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		/*写入数据库start*/
		
		
		/*写入数据库end*/
		
		userDao dao = new userDao();
		boolean b = dao.inset_order("sss", "ssss", 2);
		System.out.print(b);
	/*	Writer out = response.getWriter();
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("user");
		if(user == null) {
			out.write("请先登录");
		}else {
			out.write("您已成功提交订单");
			session.removeAttribute("map_order");
		}*/
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
