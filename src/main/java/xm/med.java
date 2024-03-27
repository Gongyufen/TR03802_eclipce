package xm;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class med
 */
@WebServlet("/med")
public class med extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String count=request.getParameter("text");
		medDAO mm=new medDAO();
		List<Medicine> list=mm.cha(count);
		request.setAttribute("list",list);
		if(list!=null) {
			request.getRequestDispatcher("/xm/medd.jsp").forward(request, response);
		}
	}

}
