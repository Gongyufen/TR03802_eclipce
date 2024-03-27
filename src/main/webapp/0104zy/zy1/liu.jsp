<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		session.setAttribute("id", id);
		String nr=request.getParameter("nr");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gyf?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
		String sql="insert into lyb values(null,?,?,now())";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setObject(1,id);
		stmt.setString(2,nr);
		stmt.executeUpdate();
		stmt.close();
		conn.close();
		response.sendRedirect("ck.jsp");
	%>
</body>
</html>