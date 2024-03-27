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
	<form action="denglutijiaofangshi.jsp" method="get">
		用户名：<input name="name"><br>
		密码：<input type="password" name="pwd"><br>
		验证码：<img  src="img.jsp"><br>
		<input type="submit" value="登录">
	</form>
</body>
</html>