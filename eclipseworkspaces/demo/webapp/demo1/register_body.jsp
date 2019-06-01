<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>请注册</title>
		<meta name="keywords" content="聚美优品">
		<meta name="description" content="电商网站">
		<link rel="stylesheet" type="text/css" href="css/register.css"/>
	</head>
	<body style="-webkit-user-select: none;">
		<div id="wrap">
			<div id="main">
			    <div class="login">
			    	<h3 class="login-title">注册</h3>
			    	<form action="#">
			    		<table class="table">
				    		<tr>
				    			<td>手机号码</td>
				    			<td><input type="text" name="tel" class="first"></td>
				    			<td>
				    				<p class="tip show">仅限中国大陆移动、电信、联通手机号码</p>
				    				<p class="warn hide">请输入正确的手机号码格式</p>
				    			</td>
				    		</tr>
				    		<tr>
				    			<td>电子邮箱</td>
				    			<td><input type="text" name="email" class="first"></td>
				    			<td>
				    				<p class="tip show">请输入您常用的电子邮箱地址</p>
				    				<p class="warn hide">请输入正确的电子邮箱格式</p>
				    			</td>
				    		</tr>
				    		<tr>
				    			<td>设置密码</td>
				    			<td><input type="password" name="pwd" class="first"></td>
				    			<td>
				    				<p class="tip show">仅限6~16个子母、数字、特殊符号</p>
				    				<p class="warn hide">请输入正确的密码格式</p>
				    			</td>
				    		</tr>
				    		<tr>
				    			<td>重复密码</td>
				    			<td><input type="password" class="second"></td>
				    			<td>
				    				<p class="tip show">请再次输入您设置的密码</p>
				    				<p class="warn hide">两次输入的密码不一致</p>
				    			</td>
				    		</tr>
				    		<tr>
				    			<td></td>
				    			<td>
				    				<input type="checkbox" id="cheBox">
				    				<label for="cheBox">我已阅读并同意</label>
				    				<span class="clause"><a href="#">《网络服务条款》。</a></span>
				    			</td>
				    			<td></td>
				    		</tr>
				    		<tr>
				    			<td></td>
				    			<td><input type="submit" value="注册"></td>
				    			<td></td>
				    		</tr>
			    	    </table>
			    	</form>
			    </div>
			</div>
		</div>
	</body>
</html>
