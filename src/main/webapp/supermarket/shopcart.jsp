<%@page import="tr03802_web.Product"%>
<%@page import="java.util.List"%>
<%@page import="tr03802_web.ShopCart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
</head>
<body>
	<H1>购物车</H1>
	<table border="1">
	<tr>
		<th>商品名称</th>
		<th>单价</th>
		<th>数量</th>
		<th>小计</th>
		<th>操作</th>
	</tr>
	<%
		//从session中获取购物车对象
		ShopCart shopCart = (ShopCart)session.getAttribute("shopCart");
		//如果session中还没有购物车，则创建购物车
		if(shopCart == null){
			shopCart = new ShopCart();
		}
		//总计
		double total = 0;
		//从购物车中获取所有购买的商品	
		List<Product> list = shopCart.getAll();
		//循环遍历并显示
		for(Product p: list){
			total += p.getTotal();
	%>
		<tr>
			<td><%= p.getName() %></td>
			<td>￥<%= p.getPrice() %></td>
			<td><%= p.getCount() %></td>
			<td>￥<%= p.getTotal() %></td>
			<td><a href="javascript:if(confirm('您真的要删除吗？')) location='remove.jsp?pid=<%= p.getPid() %>';">删除</a></td>
		</tr>
	<% 	
		}
	%>
	</table>
	
	<div>总计：￥<%= total %></div>
	<div>
		<a href="javascript:if(confirm('您真的要清空购物车吗？')) location='clear.jsp';">清空</a>
		<a href="plist.jsp">继续购买</a>
	</div>
	
</body>
</html>