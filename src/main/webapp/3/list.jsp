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
	<h2><%=session.getAttribute("text") %>,欢迎使用本系统</h2>
	<a href="zc.jsp">注册</a>
	<%
		//判断是否登录
		if(session.getAttribute("text")==null){
			//还没有登录
			out.println("对不起，请先<a href='denglu.jsp'>登录</a>");
		}else{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gyf?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
			String sql="select * from yh order by id desc";
			PreparedStatement stmt=conn.prepareCall(sql);
			ResultSet rs=stmt.executeQuery();
			out.println("<table border='1'>");
			while(rs.next()){
				out.print("<tr>");
				out.print("<td>"+rs.getInt(1)+"</td>");
				out.print("<td>"+rs.getInt(2)+"</td>");
				out.print("<td>"+rs.getInt(4)+"</td>");
				out.print("</tr>");
			}
			out.print("</table>");
			rs.close();
			stmt.close();
			conn.close();
		}
	%>
</body>
</html>