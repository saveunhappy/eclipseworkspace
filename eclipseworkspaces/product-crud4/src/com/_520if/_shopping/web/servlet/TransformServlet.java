package com._520if._shopping.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/transform")
public class TransformServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//表单中的口令
		String tokenInRequest = req.getParameter("token");
		//session中的口令
		String tokenInSession = (String) req.getSession().getAttribute("TOKEN_IN_SESSION");
		//判断口令是否正确
		if(tokenInRequest.equals(tokenInSession)) {
			req.getSession().removeAttribute("TOKEN_IN_SESSION");
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			String money = req.getParameter("money");
			System.out.println("转出"+money);
			out.print("转账成功");
		}else {
			System.out.println("手贱");
		}
	}
}
