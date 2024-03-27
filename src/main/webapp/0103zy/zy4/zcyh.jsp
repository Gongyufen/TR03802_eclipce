<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="zc.jsp">
		用户名：<input type="text" name="text"><br>
		密码：<input type="password" name="pass"><br>
		性别：<input type="radio" name="xb" value="男">男
		<input type="radio" name="xb" value="女">女<br>
		爱好：<input type="checkbox" name="ah" value="运动">运动
		<input type="checkbox" name="ah" value="音乐">音乐
		<input type="checkbox" name="ah" value="上网">上网
		<input type="checkbox" name="ah" value="购物">购物
		<input type="checkbox" name="ah" value="旅游">旅游<br>
		学历：<input type="text" name="xl"><br>
		自我介绍：<input type="text" name="zwjs"><br>
		<input type="submit">
	</form>
</body>
</html>