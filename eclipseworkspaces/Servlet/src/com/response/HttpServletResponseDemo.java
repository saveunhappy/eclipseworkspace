package com.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/resp")
public class HttpServletResponseDemo extends HttpServlet{


	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setCharacterEncoding("UTF-8");
		//OutputStream out = resp.getOutputStream();
		//out.write("Spring brother ".getBytes());//字节输出流对象 这个一般用于文件下载
//		PrintWriter getWriter();//字符输出流对象  输出的时候就用这个，可以支持英文和中文。
		/**
		 * 上面的两个方法只能用一个。如果用了两个就会报500错误，这是java代码错误
		 */
		//设置对象的MIME类型(内容的类型)不能写错，如果写错的的话他不知道你是什么东西，就会让你去下载。
		//中间用封号隔开，utf-8的大小写无所谓
		resp.setContentType("text/html;charset=utf-8");
		//必须先设置MIME类型再获取输出流，否则没效果的
		PrintWriter out = resp.getWriter();
		out.println("Spring brother");
		out.println("凤姐");
		//设置对象的MIME类型
	}
	
}
