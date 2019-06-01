package com._520it._03_三大作用域对象;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/scope")
public class ScopeServlet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//request   一次请求中，每次刷新都会重新请求
		Integer numInRequest = (Integer) req.getAttribute("NUM_IN_REQUESR");
		if(numInRequest == null) {
			req.setAttribute("NUM_IN_REQUEST", 1);
		}else {
			req.setAttribute("NUM_IN_REQUEST", numInRequest+1);
		}
		//---------------------------------
		//session	一次会话中，不关闭浏览器就不会改变
		Integer numInSession = (Integer)req.getSession().getAttribute("NUM_IN_SESSION");
		if(numInSession == null) {
			req.getSession().setAttribute("NUM_IN_SESSION",1);
		}
		else {
			req.getSession().setAttribute("NUM_IN_SESSION", numInSession + 1);
		}
		//---------------------------------
		//application //在整个WEB中，只要不关闭服务器，就一直有效
		Integer numInApp = (Integer) req.getServletContext().getAttribute("NUM_IN_APP");
		if(numInApp == null) {
			req.getServletContext().setAttribute("NUM_IN_APP", 1);
		}
		else {
			req.getServletContext().setAttribute("NUM_IN_APP", numInApp+1);
		}
		//---------------------------------
		
		req.getRequestDispatcher("/result").forward(req, resp);
	
	}
}
