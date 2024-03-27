<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.awt.Color" %>
<%@ page import="java.awt.Graphics" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="javax.imageio.ImageIO" %>
<%@ page import="java.util.Random" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <%!
	 	public String sj(){
		 Random rnd=new Random();
		 StringBuilder sb=new StringBuilder();
		 for(int i=0;i<4;i++){
			 int type=rnd.nextInt(2);
			 if(type==0){
				 int sz=rnd.nextInt(10);
				 sb.append(sz);
			 }else if(type==1){
				 int hz=rnd.nextInt(20902-19968+1)+19968;
				 char c=(char)hz;
				 sb.append(c);
			 }
		 }
		 return sb.toString();
	 }
	 %>
	 <%
	 	response.setContentType("image/png");
	 	BufferedImage mm=new BufferedImage(200,100,BufferedImage.TYPE_INT_RGB);
	 	Graphics g=mm.getGraphics();
	 	g.setColor(Color.pink);
	 	g.fillRect(0, 0,200,100);
	 	g.setColor(Color.yellow);
	 	g.drawString(sj(),40,40);
	 	ImageIO.write(mm,"png",response.getOutputStream());
	 	g.dispose();
	 	out.clear();
	 	out=pageContext.pushBody();
	 %>
</body>
</html>