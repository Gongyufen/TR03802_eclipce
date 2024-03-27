<%@page import="tr03802_web.ShopCart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购买</title>
</head>
<body>
	<%
		//从session中获取购物车对象
		ShopCart shopCart = (ShopCart)session.getAttribute("shopCart");
		//如果session中还没有购物车，则创建购物车
		if(shopCart == null){
			shopCart = new ShopCart();
		}
		//读取pid参数
		int pid = Integer.parseInt(request.getParameter("pid"));
		//保存到购物车
		shopCart.addNew(pid);
		//将购物车存到session中
		session.setAttribute("shopCart", shopCart);
	%>
	<div>购买成功！</div>
	<div><a href="plist.jsp">继续购买</a></div>
	<div><a href="shopcart.jsp">查看购物车</a></div>
</body>
</html>