package User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.userDao;


public class Regiter extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String sex = request.getParameter("gender");
		String telephone = request.getParameter("telephone");
		String introduce = request.getParameter("introduce");
		UserBean user = new UserBean();
		user.setEmail(email);
		user.setUsername(username);
		user.setPassword(password);
		user.setSex(sex);
		user.setTelephone(telephone);
		user.setIntroduce(introduce);
		userDao userdao = new userDao();
		boolean b = userdao.inset(user);
		if(b){
			System.out.println("ok");
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			String url = "registersuccess.jsp";
			response.sendRedirect(url);
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
