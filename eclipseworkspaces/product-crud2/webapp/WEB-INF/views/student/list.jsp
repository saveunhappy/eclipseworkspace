<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		当前登陆用户:${sessionScope.USER_IN_SESSION.username}
	</div>
	<a href="login.jsp">注销登陆</a>
	<hr>
	<a href="/product?cmd=edit">添加学生</a>
	<table border = "1" width = "80%" cellspacing="0" cellpadding="0">
	<tr>
		<td>编号</td>
		<td>名称</td>
		<td>品牌</td>
		<td>分类</td>
		<td>供应商</td>
		<td>折扣</td>
		<td>价格</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${product}" var="s" varStatus="vs">
	<tr style="background-color:${vs.count % 2==0 ?'gray':''}">
		<td>${s.id}</td>
		<td>${s.productName}</td>
		<td>${s.brand}</td>
		<td>${s.dir_id}</td>
		<td>${s.supplier}</td>
		<td>${s.salePrice}</td>
		<td>${s.cutoff}</td>
		
		<td><a href="/product?cmd=delete&id=${s.id}">删除</a>   |  
		<a href="/product?cmd=edit&id=${s.id}">编辑</a></td>      
	</tr>
	</c:forEach>
	</table>
</body>
</html>