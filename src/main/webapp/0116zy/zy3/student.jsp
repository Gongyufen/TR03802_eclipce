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
			<td>姓名</td>
			<td>班级</td>
			<td>年龄</td>
			<td>成绩</td>
		</tr>
		<c:forEach var="student" items="${list}">
			<tr>
				<td>${student.name}</td>
				<td>${student.bj}</td>
				<td>${student.age}</td>
				<td style="color:${student.cj< 60 ? 'red' : 'black'}">${student.cj}</td>
		</tr>
		</c:forEach>
	</table>
	<p>学生的平均年龄是：${pjage}</p>
	<p>学生的平均分是：${pjscore}</p>
</body>
</html>