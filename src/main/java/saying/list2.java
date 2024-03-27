package saying;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;

/**
 * Servlet implementation class list
 */
@WebServlet("/saying/list2")
public class list2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SayingDAO dd=new SayingDAO();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Saying> list=dd.query();
		//转换成json数组
		String array=JSONArray.toJSONString(list);
		//将json数组返回到客户端浏览器
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(array);
	}

}
