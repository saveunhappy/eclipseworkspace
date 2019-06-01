package com._520it_extends;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHttpServlet extends MyGenericServlet{
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		service(request,response);
	}
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String method = req.getMethod();
		System.out.println(method);
		if("GET".equals(method)) {
			doGet(req,res);
		}else if("POST".equals(method)) {
			doPOST(req,res);
		}
		
	}
	//专门用于处理post请求
	private void doPOST(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Servlet1.doPOST()");
	}
	//专门用于处理get请求
	private void doGet(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Servlet1.doGet()");
	}
}
