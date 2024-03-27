<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>处理登录要求</title>
</head>
<body>
	<%
		//处理乱码
		request.setCharacterEncoding("utf-8");
		//接收请求参数
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		//输出到浏览器
		/* out.write(name);
		out.print(pwd); */
		if("admin".equals(name)&&"123456".equals(pwd)){
			//response.sendRedirect("a.jsp")//重定义
			request.setAttribute("f","中华人民共和国");
			request.getRequestDispatcher("a.jsp").forward(request,response);
		}else{
			request.setAttribute("f","美利坚合众国");
			response.sendRedirect("b.jsp");
		}
	%>
</body>
</html>