package com._520it._core.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//context:环境的意思
//封装了请求和响应对象
public class ActionContext {
	private HttpServletRequest request;
	private HttpServletResponse response;
	//为每一个线程都分配一个ActionContext对象的副本
	private static ThreadLocal<ActionContext> threadLocal = new ThreadLocal<>();
	
	public static void setContext(ActionContext context) {
		threadLocal.set(context);
	}
	public static ActionContext getContext() {
		return threadLocal.get();
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public ActionContext(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
	
}
