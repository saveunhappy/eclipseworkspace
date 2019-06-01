package com._520it._05introspactor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/el")
public class ElServlet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Person person = new Person();
			req.setAttribute("p", person);
			req.getRequestDispatcher("/hello.jsp").forward(req, resp);
	}

}
