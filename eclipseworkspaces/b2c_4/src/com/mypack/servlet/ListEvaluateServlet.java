package com.mypack.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypack.dao.EvaluateDaoIF;
import com.mypack.dao.EvaluateDaoImpl;
import com.mypack.entity.Evaluate;
import com.mypack.entity.Goods;

@WebServlet("/ListEvaluateServlet")
public class ListEvaluateServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		//在session对象中去good对象
		Goods good=(Goods) session.getAttribute("good");
		
		//调用dao 根据商品编号查询所有评价
		EvaluateDaoIF evaDao=new EvaluateDaoImpl();
		List<Evaluate> evaLst=evaDao.queryAllEvaluateByGoodsId(good.getGoodsId());
		
		//放在application ServletContext里面
		ServletContext application=this.getServletContext();
		application.setAttribute("evaInfo", evaLst);
		
		response.sendRedirect("payfor.jsp");
	}

}
