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
		Class.forName("com.mysql.cj.jdbc.Driver");
		String name = (String) session.getAttribute("id");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gyf?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
		String sql="select * from lyb where id=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setString(1,name);
		ResultSet rs=stmt.executeQuery();
		out.println("<table border='1'>");
		while(rs.next()){
			out.print("<tr>");
			out.print("<td>"+rs.getInt(1)+"</td>");
			out.print("<td>"+rs.getInt(2)+"</td>");
			out.print("<td>"+rs.getString(3)+"</td>");
			out.print("<td>"+rs.getString(4)+"</td>");
			out.print("</tr>");
		}
		out.print("</table>");
		rs.close();
		stmt.close();
		conn.close();
	%>
</body>
</html>