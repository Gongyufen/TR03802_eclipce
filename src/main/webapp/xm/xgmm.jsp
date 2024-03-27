<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>修改密码</h1>
	<form action="../xgyz" method="get">
		账号：<input name="text"><br>
		密码：<input type="password" name="pwd"><br>
		确认密码：<input type="password" name="pwd2">
		<input type="submit" value="确认">
	</form>
</body>
</html>