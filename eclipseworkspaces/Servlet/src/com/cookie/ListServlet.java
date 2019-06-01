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
@WebServlet("/abc/list")
public class ListServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;
	//输出收件箱界面
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		
		String username = "";
//		Cookie cookie = new Cookie("currentName",username);
//		2.把cookie放入响应中，响应给浏览器，把共享的数据存储在浏览器中
		
//		resp.addCookie(cookie);
//		3.获取cookie以及cookie中的数据，因为cookie存储在请求头中所以应该通过request来获取
		Cookie[] cookies = req.getCookies();
		if(cookies!=null) {
			//如果cookie不等于null才进行迭代他，要不就会报空指针异常 
		for (Cookie cookie2 : cookies) {
			String name = cookie2.getName();
			String value = cookie2.getValue();
//			System.out.println(name+"===="+value);
			if("currentName".equals(name)) {
				username = URLDecoder.decode(value, "UTF-8");
			}
		}
		}
		out.println("欢迎:"+username+"<br/>");
		
		for (int i = 1; i < 6; i++) {
			out.println("<a href='/cookie/get'>收件箱</a><br/>");
		}
		
		
	}
}
