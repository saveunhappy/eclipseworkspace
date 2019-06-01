package com.mypack.servlet;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/ListAddressServlet")
public class ListAddressServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("name");
		
		User user=new User();
		user.setUsername(username);
		
		AddressDaoIF addrDao=new AddressDaoImpl();
		List<Address> addrLst=addrDao.queryAllAddr(user);
		
		
		session.setAttribute("addressInfo", addrLst);
		
		response.sendRedirect("dingdan.jsp");
		
		
		
	}

}
