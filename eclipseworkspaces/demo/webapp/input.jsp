<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String token = UUID.randomUUID().toString();
		session.setAttribute("TOKEN_IN_SESSION", token);
	%>
	<form action="/transform" method="post">
		<input type="hidden" name="token" value="<%= token%>"/>
		转账金额:<input type="text" name="money" required/>
		<input type="submit" value="转账"/>
	</form>
</body>
</html>