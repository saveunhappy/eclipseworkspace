package com.mypack.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypack.dao.AddressDaoIF;
import com.mypack.dao.AddressDaoImpl;
import com.mypack.entity.Address;
import com.mypack.entity.User;

@WebServlet("/AddAddressServlet")
public class AddAddressServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String receiver=request.getParameter("receiver");
		
		String sheng=request.getParameter("sheng");
		
		
		String city=request.getParameter("city");
		
		
		String qu=request.getParameter("qu");
		
		String region=sheng+city+qu;
		
		String detailAddr=request.getParameter("detailAddr");
		
		String tel=request.getParameter("tel");
		
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("name");
		
		User user=new User();
		user.setUsername(username);
		
		Address addr=new Address(receiver, region, detailAddr, tel,user);
		
		AddressDaoIF addrDao=new AddressDaoImpl();
		addrDao.addAddress(addr);
		
		response.sendRedirect("ListAddressServlet");
		
		
		
		
	}

}
