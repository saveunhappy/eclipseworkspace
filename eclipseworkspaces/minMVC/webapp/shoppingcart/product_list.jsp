<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="/shoppingcart?cmd=save" method="post">
		商品名称
		<select name="name">
			<option>iphone</option>
			<option>ipad</option>
			<option>iWatch</option>
		</select>	<br>
		购买数量：<input type = "number" name = "num" min = "1" required=/>
		<input type = "submit" value="添加进购物车"/>
	</form>
	
</body>
</html>