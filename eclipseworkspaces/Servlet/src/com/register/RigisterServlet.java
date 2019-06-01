package com.register;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//处理注册的请求
@WebServlet("/register")
public class RigisterServlet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("RigisterServlet.service()");
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String city = req.getParameter("city");
			String intro = req.getParameter("intro");
			String[] hobby = req.getParameterValues("hobby");
			//设置POST中的默认编码为UTF-8
			req.setCharacterEncoding("UTF-8");
			System.out.println(username);
			System.out.println(password);
			System.out.println(city);
			System.out.println(intro);
			System.out.println(Arrays.toString(hobby));
	}

}
