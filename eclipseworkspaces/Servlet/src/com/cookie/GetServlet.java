package com.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/cookie/get")
public class GetServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;
	//输出收件箱界面
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		
		String username = "";
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie2 : cookies) {
			String name = cookie2.getName();
			String value = cookie2.getValue();
//			System.out.println(name+"===="+value);
			if("currentName".equals(name)) {
				username = URLDecoder.decode(value, "UTF-8");
			}
		}
		out.println("欢迎:"+username+"<br/>");
		
		
			out.println("龙哥，我也要请你吃饭");
		
		
		
	}
}
