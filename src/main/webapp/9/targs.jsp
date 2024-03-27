<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="x" uri="http://www.trkj.com/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<x:date pattern="yyyy年-MM月-dd日 HH时:mm分:ss秒">服务器时间：</x:date>
	<div>
		<x:repeat cnt="3">蛋仔派对启动！！！</x:repeat>
	</div>
	<%
		List list=new ArrayList();
		list.add("ddd");
		list.add("yyy");
		list.add("www");
		pageContext.setAttribute("list",list);
	%>
	<x:iterator item="cur" collection="${list}">
		<div>${cur}</div>
	</x:iterator>
</body>
</html>