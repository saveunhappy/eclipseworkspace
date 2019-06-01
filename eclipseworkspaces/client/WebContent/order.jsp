<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import ="java.util.Map" import = "car.book" import = "java.util.Iterator"
    import =  "java.util.HashMap"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>订单</title>
<link rel="stylesheet" href="css/main.css" type="text/css" />
<script type="text/javascript" src="js/autoplay.js"></script>
<style>
.order_table1{
	width:500px;
	height:300px;
	position:relative;
	margin:50px auto;
	padding:50px;
	padding-left:80px;
	border:10px double rgb(200,155,145);
	border-radius:35px;
	box-shadow:-5px 5px 5px 3px rgb(200,155,145);
}
.order_table2{
	width:700px;
	height:150px;
	position:relative;
	margin:0px auto;
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

<%
	Map map_car = (Map)session.getAttribute("map_car");//获得购物车map;
	double sum = 0; //			存储订单总价；
	if(map_car == null){
		%>
		<h3>暂无订单内容，快去选购吧</h3>
		<a href = "book_wx.html"/>
		<%
	}else{
		String[] box = request.getParameterValues("sele_order");
		if(box != null){							//如果提交有内容
			Map map_order = new HashMap();			//创建一个订单map;
			
			for(int i=0;i<box.length;i++){
				book n_book = (book)map_car.get(box[i]);
				String numberString =request.getParameter(box[i]);//获取购物车输入的书籍数量；
				int book_number = Integer.parseInt(numberString);
				n_book.setBook_number(book_number);		//将购物车输入的数量加入书籍信息；
				map_order.put(box[i], n_book);		//将所选书籍改变成购物车输入的数量后从购物车添加到订单
				map_car.remove(box[i]);	
			}
			session.setAttribute("map_order", map_order);   //将订单添加到session；
		
%>
<div  class = "order_table1">
<table align = "center">
		<tr>
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

<%
	//Map map_order = (Map)session.getAttribute("map_order");
	Iterator entries = map_order.entrySet().iterator(); 
	
	while (entries.hasNext()) { 
		  Map.Entry entry = (Map.Entry) entries.next(); 
		  String key = (String)entry.getKey(); 
		  book a = (book)entry.getValue();
%>

	
		<tr>
			
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
				<%=a.getBook_Number() %>
			</td>
			<td>
				<%=a.getBook_price()*a.getBook_Number() %>
				<% sum +=a.getBook_price()*a.getBook_Number();%>
			</td>
			
		</tr>
<% 			
			}	//循环结束；
%>
		<tr>
			<td>
				订单合计：
			</td>
			<td>
				<%=sum %>
			</td>
			<td>
				
			</td>
		</tr>
<%
		}else{
			%>
				<h3>无内容</h3>
			<%
		}
	
	}
	
%>
	</table>
	</div>
	
<form action = "submit_order.jsp" >
	<table align = "center" class = "order_table2">
		<tr>
			<td>
				<h3>请填写收货人信息</h3>
			</td>
		</tr>
		<tr>
			<td>
				收货地址：
			</td>
			<td>
				<input type = "text" name = "address">
			</td>
		</tr>
		<tr>
			<td>
				收货人电话：
			</td>
			<td>
				<input type = "text" name = "phone">
			</td>
		</tr>
		<tr>
			<td>
			</td>
			<td>
				<input type = "hidden" name = "sum" value = "<%=sum %>">
			</td>
		</tr>
			
		<tr>
			<td>
			<input type = "submit" value = "提交订单">
			</td>
		</tr>		
	</table>
</form>

	<!--5. 网上书城底部 start -->
	<%@include file = "foot.jsp" %>
	<!-- 网上书城底部  end -->




</body>
</html>