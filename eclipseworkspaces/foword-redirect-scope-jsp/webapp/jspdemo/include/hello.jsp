<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
		//jap的四大作用域
			//pageContext.setAttribute("msg","pageContextValue");
			//request.setAttribute("msg", "requsetValue");
			session.setAttribute("msg", "sessionValue");
			application.setAttribute("msg", "applicationValue");
			
		%>
		<h3>使用EL获取不同作用域中的属性值</h3>
		pageContext:${pageScope.msg }<br/>
		request:${requestScope.msg }<br/>
		session:${sessionScope.msg }<br/>
		application:${applicationScope.msg }<br/>
		
		
		
		
		
		
		<h3>获取出每一个作用域中的数据</h3>
		pageContext:<%=pageContext.getAttribute("msg") %><br/>
		requset:<%=request.getAttribute("msg") %><br/>
		session:<%=session.getAttribute("msg") %><br/>
		application:<%=application.getAttribute("msg") %><br/>
		<hr/>
		<h3>page</h3>
		<%=pageContext.findAttribute("msg") %>
		${msg}
</body>
</html>