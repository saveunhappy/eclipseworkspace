package com.mypack.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypack.dao.CartDaoIF;
import com.mypack.dao.CartDaoImpl;
import com.mypack.entity.Goods;
import com.mypack.entity.Item;
import com.mypack.entity.User;

@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//取商品编号和商品购买数量
		String ids=request.getParameter("goodsId");
		int goodsId=Integer.parseInt(ids);
		
		String amount=request.getParameter("amount");
		int nums=Integer.parseInt(amount);//商品数量
		
		//取用户名
		String username=(String)request.getSession().getAttribute("name");
		
		//封装到Item对象里面
		Goods good=new Goods();
		good.setGoodsId(goodsId);
		
		User user=new User();
		user.setUsername(username);
		
		Item item=new Item(good, nums, user);
		
		//添加到cart
		CartDaoIF cartDao=new CartDaoImpl();
		boolean flag=cartDao.addCart(item);
		
		//判断是否添加成功
		if(flag){
			response.sendRedirect("ListCartServlet");
		}else{
			response.sendRedirect("goodsDetail.jsp");
		}
		
		
		
	}

}
