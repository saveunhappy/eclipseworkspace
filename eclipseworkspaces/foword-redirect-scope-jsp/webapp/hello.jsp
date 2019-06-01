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
		pageContext.setAttribute("list1",new java.util.ArrayList());
	
	%>
	haha:${empty list1}
	hh:${1 == 1}

	上下文路径:${pageContext.getRequest().getContextPath()}
	上下文路径:$(pageContext.request.contextPath)
	<h3>Person的对象信息</h3>
	<br/>username:${p.username}-->${p["username"]}
	<br/>age:${p.age}
	<br/>hobby:${p.hobby[1]}
	<br/>list:${p.list[2]}
	<br/>map:${p.map}
	<br/>map:${p.map.company }
		
	<br/>map:${p.map["www.xiaomage.com"]}
</body>
</html>