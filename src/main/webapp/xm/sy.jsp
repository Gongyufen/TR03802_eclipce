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
	登录成功<br>
	<a href="<c:url value='xxyz'/>">个人信息维护</a>
	<a href="<c:url value="medicinee"/>">查看当前用户所有用药记录</a><br>
	<form action="med">
			按照月份查找用药记录：<input name="text">
			<input type="submit" value="查找">
	</form>
</body>
</html>