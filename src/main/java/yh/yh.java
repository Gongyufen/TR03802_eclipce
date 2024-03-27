package yh;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;

/**
 * Servlet implementation class yh
 */
@WebServlet("/yh/yy")
public class yh extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SayingDAO2 ss=new SayingDAO2();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Yonghu> list=ss.query();
		String array=JSONArray.toJSONString(list);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(array);
	}

}
