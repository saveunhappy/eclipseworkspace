package com.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/cookie/login")
public class LoginServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;
	//处理登陆请求并输出欢迎界面
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
//		1.创建cookie对象
		String username = req.getParameter("username");
		Cookie cookie = new Cookie("currentName",URLEncoder.encode(username, "UTF-8"));
		cookie.setPath("/");//整个应用中
		//修改cookie的值就把cookie的key给改了就行，就是上面的currentName
		/**
		 * 修改cookie的值
		 * 1.重新创建一个cookie，key一样，修改value就行
		 * 2.用cookie对象的setValue来改变值
		 * 
		 */
//		Cookie c2 = new Cookie("currentName","xx");
//		2.把cookie放入响应中，响应给浏览器，把共享的数据存储在浏览器中
		
		resp.addCookie(cookie);
//		resp.addCookie(c2);
		cookie.setValue("sss");
//		resp.addCookie(cookie);
		/**
		 * cookie的分类：
		 * 会话cookie，关闭浏览器之后cookie就消失了，缺省情况
		 * 持久化cookie，cookie可以保持指定的时间(三天，一个兴趣，一个月)
		 * 
		 * 设置cookie的最大存活时间cookie对象，setMaxAge(int seconds)
		 * seconds == 0 删除cookie
		 * seconds < 0 会话Cookie
		 * second > 0 存活指定的秒数
		 * 
		 * 删除cookie：cookie对象.setMaxAge(0);
		 */
		
//		3.获取cookie以及cookie中的数据，因为cookie存储在请求头中所以应该通过request来获取
//		Cookie[] cookies = req.getCookies();
//		for (Cookie cookie2 : cookies) {
//			String name = cookie2.getName();
//			String value = cookie2.getValue();
//			System.out.println(name+"===="+value);
//		}
		out.println("欢迎:"+username+"<br/>");
		out.println("<a href='/abc/list'>收件箱</a>");
		
	}
}
