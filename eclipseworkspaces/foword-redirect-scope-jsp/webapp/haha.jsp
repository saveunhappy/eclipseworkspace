<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	pageContext.setAttribute("num",30); 
	%>


	<c:choose>
		<c:when test="${num>20 }"> 大</c:when>
		<c:when test="${num< 40}">小</c:when>
		<c:otherwise>
		相等
		</c:otherwise>
	</c:choose>
	
	
	
	<c:forEach var="num" begin="1" end="10" step="1">
		${num}
	</c:forEach>
	<br>
	<%
		pageContext.setAttribute("list",java.util.Arrays.asList("a","b","c"));
	%>
	<c:forEach items="${list}" var="ele">
		${ele}
	</c:forEach>
</body>
</html>