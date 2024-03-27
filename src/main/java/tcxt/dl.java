package tcxt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dl
 */
@WebServlet("/tcxt/dl")
public class dl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String zh=request.getParameter("zh");
		String mm=request.getParameter("mm");
		ZhdlDAO dd=new ZhdlDAO();
		List<Zhdl>list=dd.cha(zh, mm);
		if(list!=null && !list.isEmpty()) {
			request.getRequestDispatcher("/tcxt/fkgl.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/tcxt/dl.jsp").forward(request, response);
		}
		
	}

}
