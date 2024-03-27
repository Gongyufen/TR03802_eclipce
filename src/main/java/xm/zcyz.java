package xm;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class zcyz
 */
@WebServlet("/zcyz")
public class zcyz extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text=request.getParameter("text");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		ZhuceDAO zc=new ZhuceDAO();
		List<Denglu> list=zc.zc(text, pwd, email, phone);
		if(list==null) {
			request.getRequestDispatcher("/xm/dl.jsp").forward(request, response);
			return ;
		}else {
			request.getRequestDispatcher("/xm/zc.jsp").forward(request, response);
			return ;
		}
	}

}
