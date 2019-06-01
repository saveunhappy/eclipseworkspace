<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--静态包含 --%>
	<%@include file="top.jsp" %>
	<%--动态包含 --%>
	<jsp:include page="top.jsp">
		<jsp:param value="utf-8" name="encoding"/>
	</jsp:include>
	<%--
		静态包含：用include指令的话相当于CV大法，HTML的各种声明就可以去掉了
		特点：在翻译阶段就已经把多个JSP合并在一起了，只会有一份字节码文件
		动态包含：把每一个JSP都翻译成Servlet类，在运行时期动态的合并在一起
		
		什么时候使用静态包含？什么时候使用动态包含？
		如果在包含的时候需要使用数据，只能使用动态包含
		因为在动态包含中还可以再添加一个标签<jsp:param></jsp:param>里面可以传递参数
	 --%>
	<br/>
	main代码<br/>
	
	<%@include file="foot.jsp" %>
	<br/>
</body>
</html>