<%@page import="ee.Del"%>
<%@page import="java.util.List"%>
<%@page import="ee.DelDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
    List<Del> user = (List<Del>) request.getAttribute("user");
    if (user != null) {
        for (Del dd : user) {
%>
        <p>姓名：<%= dd.getXm() %></p>
        <p>密码：<%= dd.getMm() %></p>
        <p>电话：<%= dd.getDh() %></p>
        <p>地址：<%= dd.getDz() %></p>
        <p><img alt="" src="../imges/<%= dd.getTx() %>"></p>
<%
        }
    }
%>
<%
    List<Del> user2 = (List<Del>) request.getAttribute("user");
    if (user2 != null) {
        for (Del dd : user) {
%>
       <form action="../ee/denglucg" method="post" enctype="multipart/form-data">
       		id:<input type="text" name="id">
       		修改头像：<input type="file" name="tx">
       		<input type="submit" value="更改">
       </form>
<%
        }
    }
%>
</body>
</html>