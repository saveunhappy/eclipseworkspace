package com.mypack.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypack.dao.UserDaoIF;
import com.mypack.dao.UserDaoImpl;
import com.mypack.entity.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
    	String username=request.getParameter("username");
    	String password=request.getParameter("password");
    	
    	User user=new User(username,password);//用户登录时的user对象
    	
    	//连接数据库根据用户名查询数据库user对象 查询单个
    	UserDaoIF userDao=new UserDaoImpl();
    	User u=userDao.queryUserByUsername(user);//u 表示数据库查询出的user对象
    	String msg="";
    	if(u!=null){
    		//用户名存在
    		
    		if(user.getPassword().equals(u.getPassword())){
    			msg="登录成功";
    			String name=user.getUsername();//实际的用户名
    			HttpSession session=request.getSession();
    			session.setAttribute("name",name);
    			RequestDispatcher rd=request.getRequestDispatcher("ListGoodsServlet");
    			rd.forward(request, response);
    			return ;
    			
    		}else{
    			msg="密码错误";
    			
    		}
    	}else{
    		msg="用户名不存在！请重新输入。。。";
    		
    	}
    	request.setAttribute("msg", msg);
    	RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
    	rd.forward(request, response);
	}

}
