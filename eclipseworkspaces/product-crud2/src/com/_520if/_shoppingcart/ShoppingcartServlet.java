package com._520if._shoppingcart;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/shoppingcart")
public class ShoppingcartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String cmd = req.getParameter("cmd");
		if ("save".equals(cmd)) {
			this.save(req, resp);
		} else if ("delete".equals(cmd)) {
			this.delete(req, resp);
		}
		resp.sendRedirect("/shoppingcart/cart_list.jsp");
	}

	protected void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1接收请求参数
		String name = req.getParameter("name");
		String num = req.getParameter("num");
		String id = "";
		BigDecimal price = BigDecimal.ZERO;
		if ("iphone".equals(name)) {
			id = "123";
			price = new BigDecimal("5000");
		} else if ("ipad".equals(name)) {
			id = "456";
			price = new BigDecimal("3000");
		} else if ("iWatch".equals(name)) {
			id = "789";
			price = new BigDecimal("10000");
		}
		CartItem item = new CartItem(id, name, price, Integer.valueOf(num));
		// 2调用业务方法处理请求
		/**
		 * 注意：！！如果设置的共享数据的名字起错了，会造成头疼的效果，取属性会一直娶不到，一直执行下面的setAttribute，然后一直是创建的一个新对象，
		 * 不会添加进
		 */
		ShoppingCart cart = (ShoppingCart) req.getSession().getAttribute("SHOPPINGCART_IN_SESSION");
		if (cart == null) {
			cart = new ShoppingCart();
			req.getSession().setAttribute("SHOPPINGCART_IN_SESSION", cart);
		}
		cart.save(item);
		// 3控制界面跳转
	}

	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1接收请求参数
		String id = req.getParameter("id");
		
		// 2调用业务方法处理请求
		ShoppingCart cart = (ShoppingCart) req.getSession().getAttribute("SHOPPINGCART_IN_SESSION");
		cart.delete(id);
		// 3控制界面跳转
		
	}

}
