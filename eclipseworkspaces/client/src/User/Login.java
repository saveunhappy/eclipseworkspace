package User;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.userDao;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Writer out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		userDao userdao = new userDao();
		boolean b = userdao.ch_User(username, password);
		if(b){
			
			/*将用户信息存入session*/
			HttpSession session = request.getSession();
			session.setAttribute("user", username);
			out.write("恭喜你登陆成功3秒后，为您自动跳转到首页……");
			response.setHeader("Refresh", "3;URL=index.jsp");
		}else{
			out.write("登陆失败，3秒后为你跳转到注册界面");
			response.setHeader("Refresh", "3;URL=register.jsp");
		}
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
