<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	*{
		font-size: 14px;
	}
	.tab{
		border-collapse: collapse;
		width: 600px;
		margin-bottom: 15px;
		margin-top: 10px;
	}
	.tab tr td{
		width: 150px;
		padding: 5px;
	}
	.tab tr td:first-child {
	text-align: center;
}
.tab tr td:nth-child(3) {
	text-align: center;
}
</style>
</head>
<body>
	<h1>所有留言</h1>
	<a href="insert.jsp">新留言</a>
	<c:forEach items="${list}" var="s">
		<table class="tab" border="1">
		<tr>
			<td>留言人</td>
			<td>${s.user}</td>
			<td>时间</td>
			<td><fmt:formatDate value="${s.time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		</tr>
		<tr>
			<td>留言内容</td>
			<td colspan="3">${s.content}</td>
		</tr>
	</table>
	</c:forEach>
</body>
</html>