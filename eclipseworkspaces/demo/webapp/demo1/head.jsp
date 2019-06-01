<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>index.html</title>
		<link rel="stylesheet" type="text/css" href="css/head.css"/>
		<script src="js/iconfont.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<style type="text/css">
		.icon {
			width: 1em;
			height: 1em;
			vertical-align: -0.15em;
			fill: currentColor;
			overflow: hidden;
		}
	</style>
	<body>
		<div id="top">
			<div id="location">
				<svg class="icon" aria-hidden="true">
					<use xlink:href="#icon-location"></use>
				</svg>
		<a href="index.jsp">北京</a>		
			</div>

			<div id="login">
				<ul class="login" style="list-style: none;">
					<font color="red">
						<a href="login.jsp"><li>登陆</li></a>
					</font>
					<li class="shuxian">|</li>
					 <a href="register.jsp"> <li>免费注册</li></a>
					<li class="shuxian">|</li>
					<li>我的订单</li>
					<li class="shuxian">|</li>
					<li>收藏夹</li>
					<li class="shuxian">|</li>
					<li>帮助中心</li>
				</ul>
			</div>

		</div>
		<div id="top_next">
			<div class="haigou"><img src="img/img/logo.png" /></div>
			<input type="text" id="serch" placeholder="搜索" />
			<div id="lookfor" style="background: #E4393C;">
				<div class="icon1">
					<svg class="icon search11" aria-hidden="true">
						<use xlink:href="#icon-search"></use>
				</div>
				</svg>

			</div>
			<ul class="login1" style="list-style: none;">
				<font color="red">
					<li>热搜：</li>
				</font>
				<li class="shuxian">|</li>
				<li>笔记本</li>
				<li class="shuxian">|</li>
				<li>平板</li>
				<li class="shuxian">|</li>
				<li>手机</li>
				<li class="shuxian">|</li>
				<li>墨盒</li>
				<li class="gaoji">高级搜索</li>
			</ul>
			<div id="shoppingcart">
				&emsp;
				<svg class="icon search111" aria-hidden="true">
					<use xlink:href="#icon-cart"></use>
					<div id="d1"><a href="/demo1/shoppingcart.jsp" class="gege">购物车</a>&emsp;0</div>
			</div>
			</svg>
		</div>

		</div>
		<div id="three">
			<div class="fenlei">

				<svg class="icon search111" aria-hidden="true">
					<use xlink:href="#icon-menu"></use>

					<div id="d1">全部商品分类</div>
					<svg class="icon search1111" aria-hidden="true">
						<use xlink:href="#icon-dropdown"></use>

			</div>

			<div class="dd">促销&emsp;&emsp;&emsp;&emsp;秒杀&emsp;&emsp;&emsp;&emsp;优惠券</div>

		</div>
		<div class="line">

		</div>
	</body>
</html>
