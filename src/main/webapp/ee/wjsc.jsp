<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../ee/wjsc" enctype="multipart/form-data" method="post">
		上传图片：<input type="file" name="photo">
		图片描述：<input type="text" name="desc">
		<input type="submit" value="上传">
	</form>
	<img alt="" src="../img/${photo}">
</body>
</html>