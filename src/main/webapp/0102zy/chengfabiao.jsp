<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<%for(int i=1;i<=9;i++){ %>
				<%for(int j=1;j<=i;j++){ %>
					<td><%=i+"*"+j+"="+(i*j) %></td>
					<%if(i==j){ %>
						<tr></tr>
					<%} %>
				<%} %>
			<%} %>
		</tr>
	</table>
</body>
</html>