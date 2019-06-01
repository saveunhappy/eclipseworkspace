<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
<link rel="stylesheet" href="css/main.css" type="text/css" />
<script type="text/javascript" src="js/autoplay.js"></script>
<style>
.s_form{
	width:300px;
	height:240px;
	border:solid red;
	position:relative;
	margin:50px auto;
	padding-top:50px;
	border:10px double rgb(200,155,145);
	border-radius:35px;
	box-shadow:-5px 5px 5px 3px rgb(200,155,145);
}
.s_form td{
	height:40px;
}
.s_form .s_submit{
	position:relative;
	top:160px;
	left:200px;
}

</style>
</head>
<body>
	<!-- 1.网上书城顶部 start -->
	<%@include file = "head.jsp" %>
	<!-- 网上书城顶部  end -->

	<!--2. 网上书城菜单列表  start -->
	<%@include file = "menu_search.jsp" %>
	<!-- 网上书城菜单列表  end -->
	<form action = "Login" class = "s_form">
		<table align = "center">
			<tr>
				<td>请输入账号：</td>
				<td><input type = "text" name = "username"/></td>
			</tr>
			
			<tr>
				<td>请输入密码：</td>
				<td><input type = "password" name = "password"/></td>
			</tr>
		
				<input type = "submit" value="登陆" class = "s_submit"/>
	
		
		</table>
	
	
	</form>
	<!--5. 网上书城底部 start -->
	<%@include file = "foot.jsp" %>
	<!-- 网上书城底部  end -->
</body>
</html>