<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="User.UserBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	UserBean user = (UserBean)session.getAttribute("user");

%>
<h2 align = "center"> 恭喜你：(<%=user.getUsername() %>)注册成功</h2>
<hr width = "80%"/>
<table align = "center">
	<tr height = "50px">
		<td>用户名：</td>
		<td><%=user.getUsername() %></td>
	</tr>
	<tr height = "50px">
		<td>邮箱</td>
		<td><%=user.getEmail() %></td>
	</tr>
	<tr>
		<td colspan = "2" align = "center">
			<form action = "login.jsp">
			<input type = "submit" value = "去登陆" />
			</form>
		</td>
	</tr>

</table>

</body>
</html>