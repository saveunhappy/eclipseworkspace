<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/student?cmd=save" method="post">
		<input type="hidden" name="id" value="${student.id}"/>
		姓名：<input type="text" name="name" required value="${student.name}"/>
		年龄：<input type="text" name="age" required value="${student.id}"/>
		<input type="submit" value="${student==null?"保存学生信息":"更新学生信息"}"/>
	</form>
</body>
</html>