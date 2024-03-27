<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%! public String ss(int dd){
		for(int i=2;i<dd;i++){
			if(dd%i==0){
				return "不是素数";
			}
		}
		return "是素数";
	} %>
	<%int dd=6; %>
	<%out.println(ss(dd)); %>
</body>
</html>