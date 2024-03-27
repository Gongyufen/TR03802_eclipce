<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		function sx(){
			var tt=document.getElementsByName("dd")[0];
			tt.src="img.jsp?random="+new Date().getTime();
		}
	</script>
	<img  src="img.jsp" name="dd">
	<button onclick="sx()">刷新一下</button>
</body>
</html>