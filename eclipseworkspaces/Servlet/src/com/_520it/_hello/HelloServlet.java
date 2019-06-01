package com._520it._hello;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet implements Servlet{
	
	public HelloServlet() {
		System.out.println("构造器被创建");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("对象被初始化");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("你好师姐");
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {
		System.out.println("销毁");
		
	}
	/**
	 * 底层是用class的newinstance 所以用反射来创建对象的话得有一个公共的无参数的构造器， 
	 */
	

}
