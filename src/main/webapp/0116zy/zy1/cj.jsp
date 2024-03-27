<%@page import="java.util.Random"%>
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
	<c:set var="sjs" value="${sj}" />
	<c:choose>
		<c:when test="${sjs%8==0}">恭喜你中了一等奖</c:when>
		<c:when test="${sjs%6==0}">恭喜你中了二等奖</c:when>
		<c:when test="${sjs%4==0}">恭喜你中了三等奖</c:when>
		<c:otherwise>谢谢惠顾</c:otherwise>
	</c:choose>
	<p>您抽中的数字是：${sjs}</p>
</html>