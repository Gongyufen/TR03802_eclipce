<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!public String hw(String dd){
		if(dd==null || dd.length()==0){
			return "不是回文";
		}
		int z=0;
		int y=dd.length()-1;
		while(z<y){
			if(dd.charAt(z++)!=dd.charAt(y--)){
				return "不是回文";
			}
		}
		return "是回文";
	} %>
	<% String dd="eeeed"; %>
	<% out.println(hw(dd)); %>
</body>
</html>