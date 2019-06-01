<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文学类书区</title>
<link rel="stylesheet" href="css/main.css" type="text/css" />
<!-- 导入首页轮播图css和js脚本 -->
<link type="text/css" href="css/autoplay.css" rel="stylesheet" />
<link type="text/css" href="css/book_wx.css" rel="stylesheet" />
<script type="text/javascript" src="js/autoplay.js"></script>

</head>
<body class="main">
	<!-- 1.网上书城顶部 start -->
	<%@include file = "head.jsp" %>
	<!-- 网上书城顶部  end -->

	<!--2. 网上书城菜单列表  start -->
	<%@include file = "menu_search.jsp" %>
	<!-- 网上书城菜单列表  end -->

<div class = "wx">
	<div class = "wx_1">
		<img src = "images/wx_1.JPG" alt = "wx_1"/>
		<p><a href = "book_bata.jsp?book_id=wx_1">文学一书名（点击购买）</a></p>
	</div>
	<div class = "wx_2">
		<img src = "images/wx_2.JPG" alt = "wx_2"/>
		<p><a href = "book_bata.jsp?book_id=wx_2">文学二书名（点击购买）</a></p>
	</div>
	<div class = "wx_3">
		<img src = "#" alt = "wx_3"/>
		<p><a href = "#">文学三书名（点击购买）</a></p>
	</div>
	<div class = "wx_4">
		<img src = "#" alt = "wx_4"/>
		<p><a href = "#">文学四书名（点击购买）</a></p>
	</div>
	<div class = "wx_5">
		<img src = "#" alt = "wx_5"/>
		<p><a href = "#">文学五书名（点击购买）</a></p>
	</div>
	<div class = "wx_6">
		<img src = "#" alt = "wx_6"/>
		<p><a href = "#">文学六书名（点击购买）</a></p>
	</div>
</div>
	<!--5. 网上书城底部 start -->
	<%@include file = "foot.jsp" %>
	<!-- 网上书城底部  end -->


</body>
</html>