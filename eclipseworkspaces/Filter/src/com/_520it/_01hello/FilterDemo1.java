package com._520it._01hello;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo1 implements Filter{

	public FilterDemo1() {
		System.out.println("FilterDemo1.FilterDemo1()");
	}
	public void destroy() {
		System.out.println("FilterDemo1.destroy()");
	} 

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("过滤)");
		chain.doFilter(request, response);
	}
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("FilterDemo1.init()");
	}

}
