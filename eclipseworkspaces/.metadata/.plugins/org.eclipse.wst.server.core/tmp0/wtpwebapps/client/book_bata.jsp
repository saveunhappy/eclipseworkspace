<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="jdbc.userDao" import = "car.book"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书详情</title>
<link rel="stylesheet" href="css/main.css" type="text/css" />
<script type="text/javascript" src="js/autoplay.js"></script>
<style>
.s_main{
	width:400px;
	height:400px;
	border:solid red;
	position:relative;
	margin:50px auto;
	padding:50px;
	border:10px double rgb(200,155,145);
	border-radius:35px;
	box-shadow:-5px 5px 5px 3px rgb(200,155,145);
}
.s_main span{
	display:block;
	position:relative;
	margin-top:10px ;
	margin-left:60px;
}
.s_number{
width:25px;
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

<%
	String book_id = request.getParameter("book_id");	//获得所选书籍ID
	userDao dao = new userDao();
	book new_book = dao.get_Book(book_id);	//从数据库获取所选书籍信息
	//临时存到session;
	
	session.setAttribute(book_id, new_book);
%>

<div class = "s_main">
<span><img src = "<%=new_book.getBook_img_path() %>" alt = "封面" width = "200px" height = "200px"/></br>
<span>书名:<%=new_book.getBook_name() %></span>
<span>作者:<%=new_book.getBook_writer() %></span>
<span>单价:<%=new_book.getBook_price() %></span>
<span>库存:<%=new_book.getBook_kucun() %></span>
<form action = "Addcar">
	<span>购买数量:<input type = "text" name = "number" value = "1" class = "s_number" /></span>
	<input type = "hidden" name = "book_id" value = "<%=book_id %>"/>
	<span><input type = "submit" value = "添加购物车"/></span>
</form>

</div>

</body>

	<!--5. 网上书城底部 start -->
	<%@include file = "foot.jsp" %>
	<!-- 网上书城底部  end -->
</html>