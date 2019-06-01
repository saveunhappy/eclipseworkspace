<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="err.jsp"
    
    %>
    
    
    <%--
    page指令：表示的JSP页面相关的配置信息
    常用属性：
    
    language：表示在JSP中编写的脚本语言
    contentType：表示JSP输出的MIME类型和编码
    pageEncoding：
    
    
    
    
    
    
    
    
    
    
    
    jsp标准指令：设定JSP网页的整体配置信息
    特点：
    1：并不向客户端产生任何输出
    2：指令在JSP整个文件范围内有效
    3：为翻译阶段提供了全局信息
   每一个JSP都有page指令，一般都放在第一行
   JSP三大指令：
   	page
   	include
   	taglib
    
    编写指令的语法：<% @%>
     --%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=1/0 %>>
</body>
</html>