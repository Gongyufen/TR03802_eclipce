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
		request.setCharacterEncoding("utf-8");
		String text=request.getParameter("text");
		String pass=request.getParameter("pass");
		if(text=="" || pass==""){
			out.println("提交失败");
		}
		else if(text.startsWith("trkj")){
			request.getRequestDispatcher("ok.jsp").forward(request,response);
		}else{
			response.sendRedirect("error.jsp");
		}
	%>
</body>
</html>