<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>登录</h1>
	<form action="../dlyz" method="post">
		账号：<input name="text"><br>
		密码：<input type="password" name="pwd"><br>
		<input type="submit" value="登录">
		<a href="zc.jsp">注册</a>
		<a href="xgmm.jsp">修改密码</a>
	</form>
</body>
</html>