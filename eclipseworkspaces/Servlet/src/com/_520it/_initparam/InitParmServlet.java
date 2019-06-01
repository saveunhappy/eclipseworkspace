package com._520it._initparam;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class InitParmServlet implements Servlet{
	private ServletConfig config;
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}


	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
			String encoding = config.getInitParameter("encoding");
			String name = config.getInitParameter("name");
			System.out.println(name);
			Enumeration<String> en = config.getInitParameterNames();
			while(en.hasMoreElements()) {
				String paramName = en.nextElement();
				System.out.println(paramName+","+config.getInitParameter(paramName));
			}
			if("GBK".equals(encoding)) {
				System.out.println("你好师姐");
			}else {
				System.out.println("hell0 world");
			}
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {
		
	}
	public ServletConfig getServletConfig() {
		return null;
	}
}
