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
		String name=request.getParameter("xz");
		if("白羊座".equals(name)){
			response.sendRedirect("byz.jsp");
		}else if("金牛座".equals(name)){
			response.sendRedirect("jnz.jsp");
		}else if("双子座".equals(name)){
			response.sendRedirect("szz.jsp");
		}else if("巨蟹座".equals(name)){
			response.sendRedirect("jxz.jsp");
		}else if("狮子座".equals(name)){
			response.sendRedirect("shzz.jsp");
		}else if("处女座".equals(name)){
			response.sendRedirect("cnz.jsp");
		}else if("天秤座".equals(name)){
			response.sendRedirect("tcz.jsp");
		}else if("天蝎座".equals(name)){
			response.sendRedirect("txcz.jsp");
		}else if("射手座".equals(name)){
			response.sendRedirect("ssz.jsp");
		}else if("摩羯座".equals(name)){
			response.sendRedirect("mjz.jsp");
		}else if("水瓶座".equals(name)){
			response.sendRedirect("spz.jsp");
		}else if("双鱼座".equals(name)){
			response.sendRedirect("syz.jsp");
		}
	%>
</body>
</html>