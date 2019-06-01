package com.mypack.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypack.dao.IUserDAO;
import com.mypack.dao.impl.UserDAOImpl;
import com.mypack.domain.User;

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
		User user = dao.getUserByUsername(username);
		if(user.getUsername()==null) {
			req.setAttribute("errorMsg", "亲，账号不存在或者被禁用了");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		if(!user.getPassword().equals(password)) {
			req.setAttribute("errorMsg", "账号或者密码错误");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		req.getSession().setAttribute("USER_IN_SESSION", user);
		resp.sendRedirect("/product");
		//3控制界面跳转
		
	}
}
