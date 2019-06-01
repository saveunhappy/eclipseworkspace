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
	<form action="/product?cmd=save" method="post">
		<table border="1" cellpadding="1" cellspacing="1">
		<input type="hidden" name="id" value="${product.id}"/>
		<tr>
		<td>货品分类<td/>
		<td>名称<input type="text" name="productName" required value="${product.productName}"/><td/>
		<tr/>
		<tr>
		<td>品牌<td/>
		<td>年龄：<input type="text" name="brand" required value="${product.brand}"/><td/>
		<tr/>
		<tr>
		<td>货品分类<td/>
		<td>分类<input type="text" name="supplier" required value="${product.supplier}"/><td/>
		<tr/>
		<tr>
		<td>货品分类<td/>
		<td>供应商：<input type="text" name="salePrice" required value="${product.salePrice}"/><td/>
		<tr/>
		<tr>
		<td>货品分类<td/>
		<td>折扣<input type="text" name="costPrice" required value="${product.costPrice}"/><td/>
		<tr/>
		<tr>
		<td>货品分类<td/>
		<td>价格<input type="text" name="cutoff" required value="${product.cutoff}"/><td/>
		<tr/>
		<tr>
		<td>操作<td/>
		<td>
		<select name="dir_id">
			<c:forEach items="${dirs}" var="dir">
			<option value="${dir.id}" ${product.dir_id==dir.id?"selected":""}>${dir.dirName}<option/>
			</c:forEach>
		</select>
		
		
		<td/>
		<tr/>
		<input type="submit" value="${product==null?"保存学生信息":"更新学生信息"}"/>
		</table>
	</form>
</body>
</html>