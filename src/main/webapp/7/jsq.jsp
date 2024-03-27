<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	func
</script>
</head>
<body>
	<div>
		<form method="post" action="../CalServlet">
			<input name="a" value="${a}">
			<select name="o">
				<option value="+" ${o eq "+" ?"selected":""}>+</option>
				<option value="-" ${o eq "-" ?"selected":""}>-</option>
				<option value="*" ${o eq "*" ?"selected":""}>*</option>
				<option value="/" ${o eq "/" ?"selected":""}>/</option>
				<option value="%" ${o eq "%" ?"selected":""}>%</option>
			</select>
			<input name="b" value="${b}">
			<input type="submit" value="=">
		</form>	
	</div>
	<div>${r}</div>
</body>
</html>