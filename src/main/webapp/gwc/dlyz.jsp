<%@page import="java.sql.ResultSet"%>
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
	request.setCharacterEncoding("utf-8");
	String name=request.getParameter("name");
	String pwd=request.getParameter("pwd");
	String sql="select * from users where username=? and userpass=?";
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ff?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
	PreparedStatement stmt = conn.prepareStatement(sql);
	stmt.setString(1,name);
	stmt.setString(2,pwd);
	ResultSet rs=stmt.executeQuery();
	if(rs.next()){
		session.setAttribute("uid", rs.getInt("uid"));
		session.setAttribute("name", name);
		response.sendRedirect("sp.jsp");
	}else{
		out.print("登录失败<a href='dl.jsp'>重新登录</a>");
		
	}
	rs.close();
	stmt.close();
	conn.close();
	%>
</body>
</html>