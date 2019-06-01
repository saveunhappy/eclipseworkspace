<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/product" method="post">
		商品名称<input type="text" name="name" value="${qo.name}"/>
		<input type="text" name="minSalePrice" value="${qo.minSalePrice}"/>到
		<input type="text" name="maxSalePrice" value="${qo.maxSalePrice}"/>
		商品分类：
		<select name="dirId">
		
			<option value="-1">所有分类</option>
			<c:forEach items="${dirs}" var="d">
			
			<option value="${d.id}" ${d.id == qo.dirId?"selected":""}>${d.dirName}</option>
			</c:forEach>
			
		</select>
		关键字：<input type="text" name="keyword" placeholder="商品名称或品牌"/>
		<input type="submit" value="查询">
	</form>

	<table border = "1" width = "80%" cellspacing="0" cellpadding="0">
	<tr>
		<td>编号</td>
		<td>姓名</td>
		<td>年龄</td>
		<td>操作</td>
		<td>年龄</td>
		<td>操作</td>
		<td>年龄</td>
	</tr>
	<c:forEach items="${pageResult.listData}" var="s" varStatus="vs">
	<tr style="background-color:${vs.count % 2==0 ?'gray':''}">
		<td>${s.id}</td>
		<td>${s.productName}</td>
		<td>${s.brand}</td>
		<td>${s.dir_id}</td>
		<td>${s.supplier}</td>
		<td>${s.salePrice}</td>
		<td>${s.cutoff}</td>
		   
	</tr>
	</c:forEach>
	
	<tr>
		<td colspan="8" align="center">
			<a href="/page?currentPage=1">首页</a>
			<a href="/page?currentPage=${pageResult.prevPage}">上页</a>
			<a href="/page?currentPage=${pageResult.nextPage}">下页</a>
			<a href="/page?currentPage=${pageResult.totalPage}">末页</a>
			当前第${pageResult.currentPage}/${pageResult.totalPage}页
			一共${pageResult.totalCount}条数据
		
		
		</td>
	
	</tr>
	</table>
</body>
</html>