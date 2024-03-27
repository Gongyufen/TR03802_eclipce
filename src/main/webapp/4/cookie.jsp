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
		//向客户端写入cookie
		Cookie c1=new Cookie("user","Join");
		response.addCookie(c1);//写入cookie
		Cookie c2=new Cookie("address","嘟嘟");
		response.addCookie(c2);
		//从客户端读取cookie
		Cookie[]cs=request.getCookies();
		if(cs!=null){
			for(Cookie c:cs){
				out.println(c.getName()+"="+c.getValue());
				out.println("<br>");
			}
		}
	%>
</body>
</html>