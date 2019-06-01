package com.cal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//在线版的简易计算器
@WebServlet("/cal")
public class Cal extends HttpServlet{


	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		//获取一个输出流对象
		PrintWriter out = resp.getWriter();
//		2.接收表单中的数据
		String op = req.getParameter("op");
		String sNum1 = req.getParameter("num1");
		String sNum2 = req.getParameter("num2");
		String result = "";
		if(hasLength(sNum1)&&hasLength(sNum2)) {
			Integer num1 = Integer.valueOf(sNum1);
			Integer num2 = Integer.valueOf(sNum2);
			if("+".equals(op)) {
				result = num1+num2+"";
			}
			else if("-".equals(op)) {
				result = num1-num2+"";
			}
		}
//		----------------------------------
//		1.输出一个计算器的界面
		out.println("<form action='/cal' method='post'>");
		out.println("<input type='number' name='num1' value='"+sNum1+"'> ");
		out.println("<select name='op'>");
		out.println("<option>+</option>");
		out.println("<option>-</option>");
		out.println("<option>*</option>");
		out.println("<option>/</option>");
		out.println("</select>");
		out.println("<input type='number' name='num2' value='"+sNum2+"'>");
		out.println("<input type='submit' value=' = '>");
		out.println("<input type='text' value='"+result+"' disabled>");
		out.println("</form>");
	}
	private boolean hasLength(String str) {
		return str!=null&&!"".equals(str.trim());
	}

}
