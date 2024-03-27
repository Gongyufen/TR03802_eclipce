<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../ee/zc" method="post" enctype="multipart/form-data"> 
		姓名：<input type="text" name="xm">
		密码：<input type="password" name="mm">
		电话：<input name="dh">
		地址：<input name="dz">
		头像：<input type="file" name="tx">
		<input type="submit" value="注册">
	</form>
</body>
</html>