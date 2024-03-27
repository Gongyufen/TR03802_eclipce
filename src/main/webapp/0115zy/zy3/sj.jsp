<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="../../sj">
		产品id：<input value="${id}"><br>
		产品名：<input value="${name}"><br>
		图片：<img  src="imges/${tp}" width="40px" height="40px"><br>
		价格：<input value="${jg}"><br>
		产地：<input value="${cd}"><br>
		颜色：<input value="${ys}"><br>
		规格：<input value="${gg}"><br>
		<input type="submit" value="获取">
	</form>
</body>
</html>