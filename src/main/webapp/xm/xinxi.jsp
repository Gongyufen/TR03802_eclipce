
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>编号</td>
			<td>账号</td>
			<td>邮箱</td>
			<td>电话号码</td>
		</tr>
		<c:forEach var="xx" items="${list}">
			<tr>
				<td>${xx.id}</td>
				<td>${xx.zh}</td>
				<td>${xx.email}</td>
				<td>${xx.phone}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>