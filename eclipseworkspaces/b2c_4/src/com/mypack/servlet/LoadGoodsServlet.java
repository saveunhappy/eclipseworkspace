package com.mypack.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypack.dao.GoodsDaoIF;
import com.mypack.dao.GoodsDaoImpl;
import com.mypack.entity.Goods;

@WebServlet("/LoadGoodsServlet")
public class LoadGoodsServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//去参数 
		String ids=request.getParameter("goodsId");
		//转换为int类型
		int goodsId=Integer.parseInt(ids);
		
		GoodsDaoIF goodsDao=new GoodsDaoImpl();
		
		Goods good=goodsDao.queryGoodsById(goodsId);
		
		//放在session作用域里面
		request.getSession().setAttribute("good", good);
		
		RequestDispatcher rd=request.getRequestDispatcher("ListEvaluateServlet");
		rd.forward(request, response);
	}

}
