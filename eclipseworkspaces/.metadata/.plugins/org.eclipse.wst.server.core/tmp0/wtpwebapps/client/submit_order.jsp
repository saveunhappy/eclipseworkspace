<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    import ="java.util.Map" import = "car.book" import = "java.util.Iterator"
    import =  "java.util.HashMap"
    import =  "jdbc.userDao"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>订单已提交</title>
<link rel="stylesheet" href="css/main.css" type="text/css" />
<script type="text/javascript" src="js/autoplay.js"></script>
<style>
.s_order_div{
	width:500px;
	height:400px;
	border:solid red;
	position:relative;
	margin:50px auto;
	padding:50px;
	padding-left:150px;
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
<%
	String user_id = (String)session.getAttribute("user");
	String order_id = user_id+"-"+System.currentTimeMillis();//将用户名-时间戳当做订单号
	String address = request.getParameter("address");
	String phone = request.getParameter("phone");
	String sum_string = request.getParameter("sum");
	double sum = Double.parseDouble(sum_string);
	if(user_id == null) {
%>
		<h3>请先登录</h3>
<%
	}else {
		userDao dao = new userDao();	//创建dao对象用于写入数据库；	
		/*写入用户与订单的对应关系表user_order*/
		
		dao.inset_user_order(user_id, order_id, address, phone, sum);
		/****end****/
		/*****写入订单详情表order_xq******/
		Map map_order = (Map)session.getAttribute("map_order");
		Iterator entries = map_order.entrySet().iterator(); 
		 while (entries.hasNext()) { 
			  Map.Entry entry = (Map.Entry) entries.next(); 
			  String book_id = (String)entry.getKey(); 
			  book a = (book)entry.getValue();
			  int number = a.getBook_Number();
			  dao.inset_order(order_id, book_id, number);
		} 
		 /****end****/
%>
<div class = "s_order_div">
	<h3>尊敬的[<%=user_id %>]您已成功提交订单</h3>
	<p>订单号为:<%=order_id %></p>
	<p>收货地址为:<%=address %></p>
	<p>收货电话为：<%=phone %></p>
	<p>订单总额：<%=sum %></p>
	<p><a href = "index.jsp">继续购物>></a>
</div>
<%
		session.removeAttribute("map_order");
	}

%>

	<!--5. 网上书城底部 start -->
	<%@include file = "foot.jsp" %>
	<!-- 网上书城底部  end -->

</body>
</html>