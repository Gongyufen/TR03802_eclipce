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
	<div>
		<%=session.getAttribute("name")==null?"游客":session.getAttribute("name") %>,欢迎你
	</div>
	<h1>商品列表</h1>
	<%
	String sql="select * from products order by pid desc";
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/购物车?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
	PreparedStatement stmt = conn.prepareStatement(sql);
	ResultSet rs=stmt.executeQuery(); 
	while(rs.next()){
	%>
		<div><%=rs.getString("pname") %></div>
		<div><%=rs.getString("price") %>元</div>
		<%
			out.print("<div><a href='gwc_add.jsp?pid="+rs.getInt("pid")+"'>加入购物车</a></div>");
		%>
		
		<hr/>
	<% 
	}
	rs.close();
	stmt.close();
	conn.close();
	%>
</body>
</html>