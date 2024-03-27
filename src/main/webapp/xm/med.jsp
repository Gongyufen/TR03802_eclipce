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
			<td>记录id</td>
			<td>用户id</td>
			<td>吃药时间</td>
			<td>病情</td>
			<td>提醒方式</td>
		</tr>
		<c:forEach var="med" items="${list}">
			<tr>
				<td>${med.jlid}</td>
				<td>${med.yhid}</td>
				<td>${med.medtime}</td>
				<td>${med.bq}</td>
				<td>${med.txfs}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>