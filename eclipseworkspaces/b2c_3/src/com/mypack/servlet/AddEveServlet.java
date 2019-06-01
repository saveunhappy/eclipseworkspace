package com.mypack.servlet;

import java.io.IOException;
import java.util.Date;

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
import com.mypack.util.DateUtil;

@WebServlet("/AddEveServlet")
public class AddEveServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//处理post中文乱码
		request.setCharacterEncoding("utf-8");
		//取评价星级 int 
		String grade=request.getParameter("grade");
		int score=Integer.parseInt(grade);
		
		//取评价内容
		String content=request.getParameter("content");
		
		//取待评价的商品编号
		String ids=request.getParameter("goodsId");
		int goodsId=Integer.parseInt(ids);
		
		//吧goodsId通过Goods对象来携带
		Goods good=new Goods();
		good.setGoodsId(goodsId);;
		
		//获取评价人 当前登录用户
		HttpSession session=request.getSession();
		String evaName=(String) session.getAttribute("name");
		
		//获取系统当前时间
		String evaDate=DateUtil.dateToString(new Date());
		
		//封装到Evaluate对象里面 
		Evaluate eva=new Evaluate(evaName, content, score, evaDate, good);
		
		//调用dao添加的逻辑
		EvaluateDaoIF evaDao=new EvaluateDaoImpl();
		evaDao.addEvaluate(eva);
		
		response.sendRedirect("ListEvaluateServlet");
		
		
	}

}
