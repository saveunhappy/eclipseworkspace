<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import ="java.util.Map" import = "car.book" import = "java.util.Iterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>购物车</title>
<link rel="stylesheet" href="css/main.css" type="text/css" />
<script type="text/javascript" src="js/autoplay.js"></script>
<style>
.car_table{
	width:700px;
	height:400px;
	border:solid red;
	position:relative;
	margin:50px auto;
	padding:50px;
	padding-left:100px;
	border:10px double rgb(200,155,145);
	border-radius:35px;
	box-shadow:-5px 5px 5px 3px rgb(200,155,145);
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

<div class = "car_table">
<table >
		<tr>
			<th>
				选择
			</th>
			<th>
				封面
			</th>
			<th>
				书名
			</th>
			<th>
				作者
			</th>
			<th>
				单价
			</th>
			<th>
				数量
			</th>
			<th>
				单品小计
			</th>
		</tr>
<form action = "order.jsp">
<%
	Map map_car = (Map)session.getAttribute("map_car");
	if(map_car == null){
%>
	<tr>
		<td colspan = "6"><h3 align = "center">空空如也</h3></td>
	</tr>
<%
	}else{
	Iterator entries = map_car.entrySet().iterator(); 
	
	while (entries.hasNext()) { 
		  Map.Entry entry = (Map.Entry) entries.next(); 
		  String key = (String)entry.getKey(); 
		  book a = (book)entry.getValue();
%>

	
		<tr>
			<td>
				<input type = "checkbox" name = "sele_order" value = <%=key %>>
			</td>
			<td>
				<img src = "<%=a.getBook_img_path() %>" alt = "图书封面" width = "50px" height = "50px"/>
			</td>
			<td>
				<%=a.getBook_name() %>
			</td>
			
			<td>
				<%=a.getBook_writer() %>
			</td>
			<td>
				<%=a.getBook_price() %>
			</td>
			<td>
				<input type = "text" name = "<%=key %>" value = "<%=a.getBook_Number() %>">
			</td>
			<td>
				<%=a.getBook_price()*a.getBook_Number() %>
			</td>
			<td>
				<a href = "Car_rm?book_id=<%=key %>">删除</a>
			</td>
			
		</tr>
<% 		
	}
	}
%>
		
		
			
		

	</table>
		<input type = "submit" value = "确定选购" >
	</div>
</form>



	<!--5. 网上书城底部 start -->
	<%@include file = "foot.jsp" %>
	<!-- 网上书城底部  end -->

</body>
</html>