package com._520it_extends;

import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

abstract public class MyGenericServlet implements Servlet,ServletConfig,Serializable{

	private static final long serialVersionUID = 1L;
	private ServletConfig config;
	/**
	 * 服务器会自己调用构造器和init方法，子类的init中没有带参数的构造器，所以去父类中去找带参数的init方法
	 * 父类的有参数的init方法中有一个自己的无参数init方法但是此处有多态，子类中覆盖了父类中的init方法
	 * 就会调用子类自己的init方法，
	 */
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		this.init();
	}
	public void init() {
		
	}


	abstract public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException ;
	public String getServletInfo() {
		return null;
	}

	public void destroy() {
		
	}
	public ServletConfig getServletConfig() {
		return this.config;
	}

	@Override
	public String getServletName() {
		// TODO Auto-generated method stub
		return this.config.getServletName();
	}

	public ServletContext getServletContext() {
		// TODO Auto-generated method stub
		return this.config.getServletContext();
	}

	public String getInitParameter(String name) {
		return this.config.getInitParameter(name);
	}

	public Enumeration<String> getInitParameterNames() {

		return this.config.getInitParameterNames();
	}
}
