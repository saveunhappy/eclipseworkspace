package com.mypack.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypack.entity.Item;
@WebServlet("/JieSuanServlet")
public class JieSuanServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//取购买数量
		String[] amounts=request.getParameterValues("amount");
		//取商品信息
		HttpSession session=request.getSession();
		List<Item> cartlst=(List<Item>) session.getAttribute("cartInfo");
		double total=0;//总计
		for (int i = 0; i < amounts.length; i++) {
			Item item=cartlst.get(i);
			int newnums=Integer.parseInt(amounts[i]);
			item.setNums(newnums);
			double xiaoji=item.getGood().getPrice()*newnums;
			total+=xiaoji;
			
		}
		session.setAttribute("cartInfo", cartlst);
		session.setAttribute("total", total);
		
		response.sendRedirect("chenggong.jsp");
		
	}

}
