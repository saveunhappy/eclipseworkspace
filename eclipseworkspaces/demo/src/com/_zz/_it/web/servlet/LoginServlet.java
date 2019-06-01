package com._zz._it.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com._zz._it._dao.IUserDAO;
import com._zz._it._dao._Impl.UserDAOImpl;
import com._zz._it._domain.User;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private IUserDAO dao;
	@Override
	public void init() throws ServletException {
		dao = new UserDAOImpl();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("utf-8");
		//1接收请求参数
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//2调用业务方法处理请求
		System.out.println(password);
		User user = dao.getUserByUsername(username);
		if(user.getUsername()==null) {
			req.setAttribute("errorMsg", "亲，账号不存在或者被禁用了");
			resp.sendRedirect("/demo1/login.jsp");
			return;
		}
		if(!user.getPassword().equals(password)) {
			req.setAttribute("errorMsg", "账号或者密码错误");
			resp.sendRedirect("/demo1/login.jsp");
			return;
		}
		req.getSession().setAttribute("USER_IN_SESSION", user);
		resp.sendRedirect("/product");
		//3控制界面跳转
		
	}
}
