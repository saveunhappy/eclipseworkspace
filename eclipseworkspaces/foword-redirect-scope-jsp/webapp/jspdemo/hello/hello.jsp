<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
			//java代码
			String name = "ab";
			boolean man = true;
		%>
		<%=
		//相当于是out.print(name);这里是输出的
		name
		%>
		<%!
			private int age;
			public void doWork(){
				
			}
		%>
</body>
</html>