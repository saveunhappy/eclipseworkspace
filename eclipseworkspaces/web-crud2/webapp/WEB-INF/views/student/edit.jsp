<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/student?cmd=save" method="post">
		<input type="hidden" name="id" value="${student.id}"/>
		姓名：<input type="text" name="username" required value="${student.username}"/>
		年龄：<input type="text" name="password" required value="${student.password}"/>
		<input type="submit" value="${student==null?"保存学生信息":"更新学生信息"}"/>
	</form>
</body>
</html>