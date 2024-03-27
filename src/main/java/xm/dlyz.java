package xm;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dlyz
 */
@WebServlet("/dlyz")
public class dlyz extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text=request.getParameter("text");
		String pwd=request.getParameter("pwd");
		DengluDAO dao=new DengluDAO();
		List<Denglu> list=dao.cha(text, pwd);
		if(list != null && !list.isEmpty()) {
			request.getRequestDispatcher("/xm/sy.jsp").forward(request, response);
			System.out.println("1212");
			return ;
		}else {
			request.getRequestDispatcher("/xm/dl.jsp").forward(request, response);
		}
	}

}
