package com._520it._04_Context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/app")
//演示ServletContext接口中的方法
public class ServletContextDemo extends HttpServlet{


	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		ServletConfig接口中有这个方法
		ServletContext app1 = super.getServletContext();
		//请求中有这个方法
		ServletContext app2 = req.getServletContext();
		//通过session来获取
		ServletContext app3 = req.getSession().getServletContext();
		//String getRealPath(String path):根据一个资源的相对web跟的路径来获取他的绝对路径
		String realPath = super.getServletContext().getRealPath("/WEB-INF/123.html");
		System.out.println(realPath);
		//String getContextPath();获取当前相应的上下文路径<Context path="XXXX"/>
		//获取全局的初始化参数：
		//String getInitParameter(String name)
		//Enumration<String> getInitParameters();
		System.out.println(super.getServletContext().getInitParameter("encoding"));
		System.out.println(super.getInitParameter("encoding"));
		//super.getInitParameter("encoding")
		//ServletConfig只能获取当前servlet自身的初始化参数不能获取全局的初始化参数里面传入的参数应该是全限定名或者是小名，这里是猜测的
		
	}
}
