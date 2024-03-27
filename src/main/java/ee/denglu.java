package ee;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class denglu
 */
@WebServlet("/ee/denglu")
@MultipartConfig
public class denglu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String xm=request.getParameter("xm");
		String mm=request.getParameter("mm");
		DelDAO dd=new DelDAO();
		List<Del> list=dd.queryqq(xm, mm);
		if(list.size()!=0) {
			request.setAttribute("user", list);
			request.getRequestDispatcher("/ee/denglucg.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/ee/denglu.jsp").forward(request, response);
		}
	}

}
