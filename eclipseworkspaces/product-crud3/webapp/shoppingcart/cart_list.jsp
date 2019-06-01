<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>购物车列表</h3>
	<table cellpadding="0" cellspacing="0" width="500" border="1">
		<tr>
		<td>商品名称</td>
		<td>零售价格</td>
		<td>购买数量</td>
		<td>操作 </td>
		</tr> 
		
		<c:if test="${empty SHOPPINGCART_IN_SESSION.items}">
			<tr>
				<td>亲，购物车为空，快去<a href="/shoppingcart/product_list.jsp">购物吧</a></td>
			</tr>
		</c:if>
		<c:if test="${!empty SHOPPINGCART_IN_SESSION.items}">
		<c:forEach items="${SHOPPINGCART_IN_SESSION.items}" var="item">
		<tr>
			<td>${item.name}</td>
			<td>${item.price}</td>
			<td>${item.num}</td>
			<td><a href="/shoppingcart?cmd=delete&id=${item.id}">删除</a></td>
		</tr>
		</c:forEach>
		<tr align="right">
			<td colspan="4">购物车总价${SHOPPINGCART_IN_SESSION.totalPrice}</td>
		</tr>
		</c:if>
	</table>
	<a href="/shoppingcart/product_list.jsp">去购物</a>
</body>
</html>