package saying;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class delete
 */
@WebServlet("/saying/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SayingDAO dd=new SayingDAO();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String [] sids=request.getParameterValues("sid");
		dd.deleted(sids);
		request.getRequestDispatcher("listpage?curpage=1&pagesize=3&").forward(request, response);
	}

}
