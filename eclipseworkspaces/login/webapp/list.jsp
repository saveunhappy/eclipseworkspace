<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border = "1" width = "80%" cellspacing="0" cellpadding="0">
	<tr>
		<td>编号</td>
		<td>账号</td>
		<td>密码</td>
	</tr>
	<c:forEach items="${list}" var="s" varStatus="vs">
	<tr style="background-color:${vs.count % 2==0 ?'gray':''}">
		<td>${s.id}</td>
		<td>${s.username}</td>
		<td>${s.password}</td>
	</tr>
	</c:forEach>
</body>
</html>