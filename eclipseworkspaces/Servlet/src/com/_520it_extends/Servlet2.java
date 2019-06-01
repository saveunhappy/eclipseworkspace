package com._520it_extends;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet2 implements Servlet{
	private ServletConfig config;
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}

	

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String encoding = config.getInitParameter("encoding");
	}
	public String getServletInfo() {
		return null;
	}

	public void destroy() {
		
	}
	public ServletConfig getServletConfig() {
		return this.config;
	}
}
