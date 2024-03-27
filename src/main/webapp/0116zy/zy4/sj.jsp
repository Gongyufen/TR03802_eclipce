<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
ul {
    float: left;
    width: 50%;
    padding: 0;
    margin: 0;
    list-style-type: none;
}
</style>
</head>
<body>
    <c:forEach var="ff" items="${list}" varStatus="status">
        <c:if test="${status.index % 2 == 0}">
            <div>
        </c:if>
        <ul>
            <li>编号：${ff.id}</li>
            <li>商品名称：${ff.name}</li>
            <li>商品价格：${ff.price}</li>
            <li>商品图片路径：${ff.src}</li>
            <li>商品描述：${ff.ms}</li>
            <li>评价人数：${ff.pjrs}</li>
            <li>好评度：<fmt:formatNumber value="${ff.hpd}" type="percent" /></li>
        </ul>
        <c:if test="${status.index % 2 == 1 or status.last}">
            </div>
        </c:if>
    </c:forEach>
</body>
</html>
