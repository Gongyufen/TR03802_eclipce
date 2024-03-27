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
		String text=request.getParameter("text");
		String pwd=request.getParameter("pwd");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gyf?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
		String sql="select * from yh where namee=? and pwd=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setString(1,text);
		stmt.setString(2,pwd);
		ResultSet rs=stmt.executeQuery();
		if(rs.next()){
			response.sendRedirect("list.jsp");
			session.setAttribute("name",text);
		}else{
			out.println("登录失败，请重新<a href='denglu.jsp'>登录</a>");
		}
		rs.close();
		stmt.close();
		conn.close();
	%>
</body>
</html>