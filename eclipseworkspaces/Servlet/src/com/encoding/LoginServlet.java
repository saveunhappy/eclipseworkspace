package com.encoding;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		//按照ISO-8859-1把乱码恢复成二进制文件
		byte[] data = username.getBytes("ISO-8859-1");
		username = new String(data,"UTF-8");
		String password = req.getParameter("password");
		System.out.println(username+""+password);
		
		/**
		 * 针对于POST请求：
		 * request.setCharacterEncoding("UTF-8");
		 * 注意：1：只针对post有效。2：必须放在获取任意参数之前
		 * 针对于GET请求：
		 *  <Connector port="80" protocol="HTTP/1.1"
				
				URIEncoding = "UTF-8"
				
               connectionTimeout="20000"
               redirectPort="8443" />
               它的默认编码是ISO-8859-1  可以通过设置来改变但是不会这么干的，不会通过get来传递中文的
               
		 */
		
	}
}
