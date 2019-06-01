<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<hr/>
${sessionScope.USER_IN_SESSION}<br>
<%

		Object obj = session.getAttribute("USER_IN_SESSION");
		if(obj==null){
			response.sendRedirect("/login.jsp");
		}
%>
<a href="/function1.jsp">功能1</a>
<a href="/function2.jsp">功能2</a>
<a href="/function3.jsp">功能3</a>