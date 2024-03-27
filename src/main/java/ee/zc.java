package ee;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class zc
 */
@WebServlet("/ee/zc")
@MultipartConfig
public class zc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Part part=request.getPart("tx");
		if(part!=null) {
			String name=part.getHeader("content-disposition");
			//文件名
			String name1= name.split(";")[2].split("=")[1].replaceAll("\"","");
			//文件后缀
			int pos=name1.lastIndexOf('.');
			String exl=name1.substring(pos);
			//随机
			String rnname=UUID.randomUUID().toString().toUpperCase();
			//获取发布后的工程目录
			String root=this.getServletContext().getRealPath("");
			//创建images子文件夹
			File imges=new File(root,"imges");
			if(!imges.exists()) {
				imges.mkdirs();
			}
			String photo=root+"/imges/"+rnname+exl;
			part.write(photo);
			DelDAO dd=new DelDAO();
			dd.insert(request.getParameter("xm"),request.getParameter("mm"),request.getParameter("dh"),request.getParameter("dz"), photo);
		}
	}

}
