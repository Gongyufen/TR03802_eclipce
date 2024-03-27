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
		int num=Integer.parseInt(request.getParameter("name"));
		boolean sf=true;
		for(int i=2;i<num;i++){
			if(num%i==0){
				sf=false;
				break;
			}
		}
		if(sf){
			out.println(num+"是素数，"+num+"以内的其他素数还有：");
			for(int i=2;i<num;i++){
				boolean hy=true;
				for(int j=2;j<i;j++){
					if(i%j==0){
						hy=false;
						break;
					}
				}
				if(hy){
					out.print(i+"、");
				}
			}
		}else{
			out.println(num+"不是素数");
		}
	%>
</body>
</html>