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
	<script>
	function jia(but,gwcid,uid){
		var parent = but.parentNode;//找到上一级元素td
		var span = parent.querySelector("span");//找到下一级input
		var cnt = span.innerHTML;
		location = "jia.jsp?gwcid="+gwcid+"&uid="+uid+"&cnt="+cnt;
	}
	function jian(but,gwcid,uid){
		var parent = but.parentNode;//找到上一级元素td
		var span = parent.querySelector("span");//找到下一级input
		var cnt = span.innerHTML;
		location = "jian.jsp?gwcid="+gwcid+"&uid="+uid+"&cnt="+cnt;
	}
	function shanchu(gwcid,uid){
		location = "shanchu.jsp?pid="+gwcid+"&uid="+uid;
	}
</script>
</head>
<body>
		<%
	String sql="select * from details where uid=?";
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ff?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
	PreparedStatement stmt = conn.prepareStatement(sql);
	stmt.setObject(1, session.getAttribute("uid"));
	ResultSet rs=stmt.executeQuery();
	out.print("<table border=1>");
	out.print("<tr>");
	out.print("<td>商品名称</td>");
	out.print("<td>单价</td>");
	out.print("<td>数量</td>");
	out.print("<td>小计</td>");
	out.print("<td>操作</td>");
	out.print("</tr>");
	double zojia=0;
	while(rs.next()){
		out.print("<tr>");
		out.print("<td>"+rs.getString("namee")+"</td>");
		out.print("<td>"+rs.getDouble("price")+"</td>");
		out.print("<td><button onclick='jian(this,"+rs.getInt("gwcid")+","+rs.getInt("uid")+")'>-</button><span>"+rs.getInt("countt")+"</span><button onclick='jia(this,"+rs.getInt("gwcid")+","+rs.getInt("uid")+")'>+</button></td>");
		out.print("<td>"+rs.getDouble("total")+"</td>");
		zojia+=rs.getDouble("total");
		out.print("<td><button onclick='shanchu("+rs.getInt("gwcid")+","+rs.getInt("uid")+")'>删除</button></td>");
		out.print("</tr>");
	}
	out.print("</table>");
	out.print("总价："+zojia);
	%>
	<a href="sp.jsp">继续购物</a>
</body>
</html>