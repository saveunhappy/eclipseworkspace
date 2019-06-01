package com.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo extends HttpServlet{
	/**
	 * 一个servlet程序可以配置多个<url-pattern>,表示个servlet可以有多个资源名称
	 * 一个servlet程序可以配置多个<servlet-mapping>
	 * load-on-startup需要在启动的时候就创建出来，使用xml配置，也可以使用注解
	 */

	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		Cookie cookie = new Cookie(String name,String value);
		//参数：
			//name：给当前的cookie取一个唯一的名字
			//value:存储cookie中的共享数据，只能是String类型的
		Cookie cookie = new Cookie("current","will");
		//把cookie放入响应中，响应给浏览器，吧共享的数据存储在浏览器中
		resp.addCookie(cookie);
		//获取cookie以及cookie中的数据
		//因为cookie存在于n请求头中，应该通过request去获取
		Cookie[] cs = req.getCookies();
		String name = cookie.getName();
		String value=  cookie.getValue();
	
	}
}
