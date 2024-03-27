<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: <%= suiji() %>">
	<%! public String suiji(){
		int red=(int)(Math.random()*256);
		int green=(int)(Math.random()*256);
		int blue=(int)(Math.random()*256);
		String sj="RGB("+red+","+green+","+blue+")";
		return sj;
	} %>
</body>
</html>