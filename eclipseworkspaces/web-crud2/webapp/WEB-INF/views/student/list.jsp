<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/student?cmd=edit">添加学生</a>
	<table border = "1" width = "80%" cellspacing="0" cellpadding="0">
	<tr>
		<td>编号</td>
		<td>姓名</td>
		<td>年龄</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${students}" var="s" varStatus="vs">
	<tr>
		<td>${s.id}</td>
		<td>${s.username}</td>
		<td>${s.password}</td>
		<td><a href="/student?cmd=delete&id=${s.id}">删除</a>   |  
		<a href="/student?cmd=edit&id=${s.id}">编辑</a></td>      
	</tr>
	</c:forEach>
	</table>
</body>
</html>