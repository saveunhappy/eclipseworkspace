package com.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session/list")
public class ListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// 输出收件箱界面
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		String username = "";
		// ============================
//		1.获取session对象
		HttpSession session = req.getSession();
//		2.获取session中存储的数据
		User user = (User) session.getAttribute("USER_IN_SESSION");
		// ============================
		out.println("欢迎:" + user.getUsername() + "<br/>");

		for (int i = 1; i < 6; i++) {
			out.println("<a href='/session/get'>收件箱</a><br/>");
		}

	}
}
