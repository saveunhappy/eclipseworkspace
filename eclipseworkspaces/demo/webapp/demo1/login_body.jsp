<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		
		<meta charset="UTF-8">
		<title>请登录</title>
		<meta name="keywords" content="聚美优品">
		<meta name="description" content="电商网站">
		<link rel="stylesheet" type="text/css" href="css/login.css"/>
		<style>
		
		
		
		</style>
	</head>
	<body style="-webkit-user-select: none;">
		<div id="wrap"><!--main s-->
			<div id="main">
			    <div class="login">
			    	<h3 class="login-title">登录</h3>
			    	<form action="/login" method="post">
			    		<table class="table">
				    		<tr>
				    			<td>账号</td>
				    			<td><input type="text" placeholder="邮箱/手机号码" name="username"></td>
				    			<td>
				    				<span>没有账号？</span>
				    				<span class="free"><a href="register.html" target="_blank">免费注册</a></span>
				    			</td>
				    		</tr>
				    		<tr>
				    			<td>密码</td>
				    			<td><input type="password" name="password"></td>
				    			<td>
				    				<span>忘记密码？</span>
				    				<span class="find"><a href="#">找回密码</a></span>
				    			</td>
				    		</tr>
				    		<tr>
				    			<td></td>
				    			<td><input type="submit" value="登录"></td>
				    			<td></td>
				    		</tr>
			    	    </table>
			    	</form>
			    	
			    </div>
			</div>
			<!--main e-->
		</div>
	</body>
</html>
>