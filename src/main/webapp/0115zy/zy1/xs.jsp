<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>学生信息</h1>
	<form action="../../ee" method="post">
		<div>
			<table border="1">
				<tr>
					<th>学号</th>
					<th>姓名</th>
					<th>身份证</th>
					<th>电话号</th>
					<th>年龄</th>
					<th>头像</th>
				</tr>
				<tr>
					<th>${id}</th>
					<th>${name}</th>
					<th>${sfz}</th>
					<th>${phone}</th>
					<th>${age}</th>
					<th><img src="imges/${tx}" width="30px" height="30px"></th>
				</tr>
			</table>
		</div>
		<input type="submit" value="获取">
	</form>
</body>
</html>