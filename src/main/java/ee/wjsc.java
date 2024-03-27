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
 * Servlet implementation class wjsc
 */
@WebServlet("/ee/wjsc")
@MultipartConfig
public class wjsc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part part=request.getPart("photo");
		//获取文件名
		String s=part.getHeader("content-disposition");
		//获得文件名
		String ss=s.split(";")[2].split("=")[1].replaceAll("\"","");
		System.out.println(ss);
		//获取扩展名
		int pos=ss.lastIndexOf('.');
		System.out.println(pos);
		String ext=ss.substring(pos);
		System.out.println(ext);
		//随机生成一个文件名，扩展名不变
		String rndname=UUID.randomUUID().toString().toUpperCase();
		//获取发布会的工程根目录
		String root=this.getServletContext().getRealPath("");
		System.out.println(root);
		//创建image子文件夹
		File img=new File(root,"img");
		if(!img.exists()) {
			img.mkdirs();//不存在，则创建img文件夹
		}
		String photo=root+"/img/"+rndname+ext;
		part.write(photo);
		System.out.println(photo);
		request.setAttribute("photo",rndname+ext);
		request.getRequestDispatcher("/ee/wjsc.jsp").forward(request, response);
	}

}
