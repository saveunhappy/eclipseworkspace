package com._520it._01_forword;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/forward/s1")
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
		//请求转发
		req.getRequestDispatcher("/forward/s2").forward(req, resp);
		/**
		 * 请求转发的特点：
		 * 	1.浏览器地址栏不发生改变，依然是原来的地址，不是目标地址
		 * 2.请求转发只发送一次请求
		 * 3.共享同一个请求中的数据
		 * 4.最终响应由目标地址来决定
		 * 5.请求转发不能跨域访问，只能跳转到当前的资源
		 * 请求转发可以访问WEB-INF中的数据
		 */
		//=====================
		System.out.println("Servlet1...after");
		out.println("Servlet1.....after");
	}
}
