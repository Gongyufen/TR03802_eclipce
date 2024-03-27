<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://www.trkj.com/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.gyf_p{
		font-size: 14px;
	}
	.gyf_p a{
	text-decoration: none;
	margin: 5px 5px;
	padding: 3px 5px;
	border: 1px solid gray;
	font-size: 12px;
}
</style>
<script type="text/javascript">
function ch(page) {
   var curpage=parseInt(page);
   var url="${pageContext.request.contextPath}/10/list?curpage="+curpage+"&pagesize=${param.pagesize}";
   location.href=url;
}
</script>
</head>
<body>
	<table>
		<tr>
			<th>id</th>
			<th>用户名</th>
			<th>用户密码</th>
			<th>注册时间</th>
		</tr>
		<c:forEach items="${list}" var="p">
			<tr>
				<td>${p.uid}</td>
				<td>${p.name}</td>
				<td>${p.pwd}</td>
				<td>${p.zc}</td>
			</tr>
		</c:forEach>
	</table>
	<x:page controller="list" pagesize="2" total="${total}" curpage="${param.curpage}" where="${keyword}"/>
	<form action='/10/list' method='GET'><input type='text' name='keyword' value='${keyword}'/><input type='submit' value='搜索'/></form>
</body>
</html>