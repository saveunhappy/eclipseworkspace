package com.mypack.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypack.dao.CartDaoIF;
import com.mypack.dao.CartDaoImpl;
import com.mypack.entity.Goods;
import com.mypack.entity.Item;
import com.mypack.entity.User;

@WebServlet("/ListCartServlet")
public class ListCartServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//查询某用户下的购物车的所有的条目信息 根据用户来查
		HttpSession session=request.getSession();
		String name=(String)session.getAttribute("name");
		User user=new User();
		user.setUsername(name);
		
		//调用dao 查询所有
		CartDaoIF cartDao=new CartDaoImpl();
		//数据库查询未合并 商品重复
		List<Item> cartLst=cartDao.queryAllCart(user);
		
		session.setAttribute("cartInfo",cartLst);
		//跳转到购物车
		response.sendRedirect("dingdan.jsp");
		
	}
	
	
}
