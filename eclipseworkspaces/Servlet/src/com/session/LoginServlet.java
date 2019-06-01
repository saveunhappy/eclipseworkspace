package com.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/session/login")
public class LoginServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;
	//处理登陆请求并输出欢迎界面
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		String username = req.getParameter("username");
		//==============================================
		User user = new User();
		user.setUsername(username);
		//1.创建和获取session对象
		HttpSession session = req.getSession();
		//2.往session中存储数据
		session.setAttribute("USER_IN_SESSION",user );
		
		/**
		 * Session的操作：
		 * 1.创建和获取session对象
		 * HttPSession session  = request.getSession(true):如果当前请求中存在一个session对象
		 * 就直接返回，如果不存在Session，就创建一个再返回
		 * HttPSession session  = request.getSession(false):如果当前请求中存在一个session对象
		 * 就直接返回，如果不存在Session，就返回一个null
		 * HttPSession session  = request.getSession()等价于HttPSession session  = request.getSession(true)
		 * 2.往Session中存储数据：
		 * session对象.setAttribute(String name,Object value)
		 * 
		 * 3.从session中得到数据：
		 * Object value = session对象.getAttribute(String key)
		 * 
		 * 
		 * 
		 * Session的细节：
		 * 一般的，我们存储到Session中的属性名称，要唯一，我们习惯XXX_IN_SESSION:
		 * session对象.setAttribute("USER_IN_SESSION","will")
		 * 若需要多个数据存放的session中就得调用setAttribute方法N次，封装成一个对象比较好
		 * 
		 * 如果多态服务器之间需要共享Session此时Session中的对象必须实现java.io.Serializeable(才能在网络上传输)
		 * 序列化：把对象存储为二进制
		 * 反序列化：把二进制恢复成对象
		 * 
		 * 4.删除session对象
		 * 1：删除session对象中指定属性名的值
		 * session对象.removeAttribute("currentName")
		 * 2:销毁Session对象
		 * session对象.invalidate()
		 * 
		 * 
		 * 5.Session对象的超时管理
		 * 在超时时间之内，如果服务端和客户端没有交互(用户的两次操作之间不能超过这个时间)，则自动的销毁session
		 * session对象.setMaxInactiveInterval(int seconds)
		 *
		 */
 
		//==============================================
		out.println("欢迎:"+username+"<br/>");
		out.println("<a href='/session/list'>收件箱</a>");
		
	}
}
