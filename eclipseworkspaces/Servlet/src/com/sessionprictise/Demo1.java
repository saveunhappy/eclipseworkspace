package com.sessionprictise;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Demo1 extends HttpServlet{
	

	


	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);//如果当前存在一个session对象就返回，不存在就创建一个再返回
		HttpSession session1 = req.getSession(false);//如果当前存在session对象就返回，果不存在session对象，就返回Null
		HttpSession session2 = req.getSession();//等价于里面有一个true
		
		/**
		 * 往session中存储数据：
		 * session对象.setAttribute(String name,Object value)
		 * 
		 * 从session中取出来数据
		 * Object value = session对象.getAttribute(String key)
		 * 删除Session 
		 * session对象.removeAttribute("currentName")
		 * 
		 * 销毁session对象(Session对象中的值都讲不存在)
		 * session对象.invalidate();
		 * 
		 * Session的超时管理
		 * 在超时时间之内，如果客户端没有和服务端做交互，就自动的销毁session
		 * session对象.setMaxInactiveInterval(60*10)//超过十分钟就销毁session
		 * Tomcat服务器默认时间是30分钟，但是在20多分钟的时候就销毁了
		 * 
		 * <session-config>
		 * 		<session-timeout>30</session-timeout>
		 * </session-config>
		 * 
		 * 
		 * 
		 * 
		 */
	}
}
