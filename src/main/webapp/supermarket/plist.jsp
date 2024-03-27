<%@page import="tr03802_web.Store"%>
<%@page import="tr03802_web.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品列表</title>
</head>
<body>
	<%
		for(Product p: Store.products){
			out.print(p.getName() + "<br>");
			out.print("单价：" + p.getPrice() + "<br>");
			out.print("库存：" + p.getCount() + "<br>");
			out.print("<a href='add.jsp?pid=" + p.getPid() +"'>添加到购物车</a>");
			out.print("<hr>");
		}
	%>
	
</body>
</html>