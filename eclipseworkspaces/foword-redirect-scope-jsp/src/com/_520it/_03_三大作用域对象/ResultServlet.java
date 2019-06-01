package com._520it._03_三大作用域对象;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/result")
public class ResultServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("request="+req.getAttribute("NUM_IN_REQUEST"));
		out.println("session="+req.getSession().getAttribute("NUM_IN_SESSION"));
		out.println("application="+req.getServletContext().getAttribute("NUM_IN_APP"));
	}		   
	
}
