<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>文件上传</h3>
	${error}
	<%--上传控件的form表单提交方式必须是post因为get请求大小是2kb --%>
	<form action="/upload" method="post" enctype="multipart/form-data">
	账号：<input type="text" name ="username"/>
	邮箱：<input type="text" name ="email"/>
	头像：<input type="file" name="image" accept="image/*"/>
	<input type="submit" value="朕要注册"/>
	</form>
</body>
</html>