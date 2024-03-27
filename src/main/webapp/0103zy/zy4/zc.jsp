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
		String yhm=request.getParameter("text");
		out.println("用户名："+yhm);
		String mm=request.getParameter("pass");
		out.println("密码："+mm);
		String xb=request.getParameter("xb");
		if("男".equals(xb)){
			out.println("性别：男");
		}else if("女".equals(xb)){
			out.println("性别：女");
		}
		String[] ah=request.getParameterValues("ah");
		for(String s:ah){
			out.print("爱好：");
			out.print(s);
		}
		String xl=request.getParameter("xl");
		out.println("学历："+xl);
		String zwjs=request.getParameter("zwjs");
		out.println("自我介绍："+zwjs);
	%>
</body>
</html>