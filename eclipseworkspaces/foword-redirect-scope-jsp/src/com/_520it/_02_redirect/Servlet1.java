package com._520it._02_redirect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/redirect/s1")
public class Servlet1 extends HttpServlet{


	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		//==============================
		System.out.println("Servlet1....before");
		out.println("Servlet1...before");
		//==============================
		//URL重定向
		resp.sendRedirect("/redirect/s2");
		/**
		 * URL重定向浏览器地址会发生改变，会去跳转到目标地址
		 * 2.URL重定向发送了两次请求
		 * 因为是发送了两次请求所以不会共享请求中中的数据
		 * 最终响应的有目标地址来决定
		 * URL重定向能跨域访问，可以访问其他的资源
		 * URL重定向不能访问WET-INF中的资源
		 */
		//=====================
		System.out.println("Servlet1...after");
		out.println("Servlet1.....after");
	}
}
