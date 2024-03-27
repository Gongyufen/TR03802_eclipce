package saying;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class listpage
 */
@WebServlet("/saying/listpage")
public class listpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SayingDAO dd=new SayingDAO();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取请求参数
		int curpage=Integer.parseInt(request.getParameter("curpage"));
		int pagesize=Integer.parseInt(request.getParameter("pagesize"));
		//调用dao
		Map<String,Object> map=dd.queryByPage(curpage, pagesize);
		request.setAttribute("map",map);
		//跳转
		request.getRequestDispatcher("listpage.jsp").forward(request, response);
	}

}
