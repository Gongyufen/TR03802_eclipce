<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/购物车?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
	int pid=Integer.parseInt(request.getParameter("pid"));
	int uid=Integer.parseInt(request.getParameter("uid"));
	String sql="delete from details where pid=? and uid=? ";
	PreparedStatement stmt = conn.prepareStatement(sql);
	stmt.setInt(1, pid);
	stmt.setInt(2, uid);
	stmt.executeUpdate();
	stmt.close();
	conn.close();
	response.sendRedirect("gwc.jsp");
	%>
	
</body>
</html>