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
	int gwcid=Integer.parseInt(request.getParameter("gwcid"));
	String sql="select * from gwc where gwcid=?";
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ff?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
	PreparedStatement stmt = conn.prepareStatement(sql);
	stmt.setInt(1,gwcid);
	ResultSet rs=stmt.executeQuery();
	if(rs.next()){
		sql="select * from details where pname=? and uid=?";
		PreparedStatement pd = conn.prepareStatement(sql);
		pd.setString(1, rs.getString("pname"));
		pd.setObject(2, session.getAttribute("uid"));
		ResultSet rs2=pd.executeQuery();
		if(rs2.next()){
			sql="update details set count_=?,total=? where pname=? and uid=? ";
			PreparedStatement stmt2 = conn.prepareStatement(sql);
			stmt2.setInt(1, rs2.getInt("count_")+1);
			stmt2.setDouble(2,(rs2.getInt("count_")+1)*rs2.getDouble("price"));
			stmt2.setString(3, rs.getString("pname"));
			stmt2.setObject(4, session.getAttribute("uid"));
			stmt2.executeUpdate();
			stmt2.close();
		}else{
			sql="insert into details values(null,?,?,?,1,?,?)";
			PreparedStatement stmt2 = conn.prepareStatement(sql);
			stmt2.setInt(1, rs.getInt("pid"));
			stmt2.setString(2, rs.getString("pname"));
			stmt2.setDouble(3, rs.getDouble("price"));
			stmt2.setDouble(4, rs.getDouble("price"));
			stmt2.setObject(5,session.getAttribute("uid"));
			stmt2.executeUpdate();
			stmt2.close();
			
		}
	}
	out.print("购买成功<br/>");
	out.print("<a href='sp.jsp'>继续购买</a><br/>");
	out.print("<a href='gwc.jsp'>查看购物车</a>");
	rs.close();
	stmt.close();
	conn.close();
	%>
</body>
</html>