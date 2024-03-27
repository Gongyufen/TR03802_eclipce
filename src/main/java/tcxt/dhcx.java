package tcxt;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dhcx
 */
@WebServlet("/tcxt/fkgg")
public class dhcx extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FkglDAO dd=new FkglDAO();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int curpage=Integer.parseInt(request.getParameter("curpage"));
		int pagesize=Integer.parseInt(request.getParameter("pagesize"));
		Map<String,Object> map=dd.queryByPage(curpage, pagesize);
		request.setAttribute("map",map);
		//跳转
		request.getRequestDispatcher("fkgl.jsp").forward(request, response);
	}

}
