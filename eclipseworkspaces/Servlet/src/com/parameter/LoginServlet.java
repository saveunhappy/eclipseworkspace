package com.parameter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/param/login")
public class LoginServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;
	//处理登陆请求并输出欢迎界面
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		
		String username = req.getParameter("username");
//		String password = req.getParameter("password");
		out.println("欢迎:"+username+"<br/>");
		out.println("<a href='/param/list?username="+username+"'>收件箱</a>");
//		System.out.println(username);
//		System.out.println(password);
		
	}
}
