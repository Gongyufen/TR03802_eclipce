<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=new java.util.Date().toLocaleString() %>
	<%
		int a=10;
		int b=20;
		int c=a+b;
		out.println(c);//输出到浏览器
		System.out.println(c);//输出到控制台
	%>
</body>
</html>