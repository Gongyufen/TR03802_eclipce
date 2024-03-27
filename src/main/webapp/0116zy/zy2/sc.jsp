<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
  <h2>选中的个人爱好：</h2>
  <c:forEach var="hobby" items="${paramValues.hobby}">
    <p>${hobby}</p>
  </c:forEach>
  <h2>表单提交的时间：</h2>
  <p><fmt:formatDate var="now" value="${now}" pattern="yyyy-MM-dd" />${now}</p>
</body>
</html>