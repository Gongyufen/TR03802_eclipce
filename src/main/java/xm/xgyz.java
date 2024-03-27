package xm;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class xgyz
 */
@WebServlet("/xgyz")
public class xgyz extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text=request.getParameter("text");
		String pwd=request.getParameter("pwd");
		String pwd2=request.getParameter("pwd2");
		if(pwd.equals(pwd2)) {
			XgmmDAO xg=new XgmmDAO();
			List<Denglu> list=xg.xg(text,pwd);
			if(list==null) {
				request.getRequestDispatcher("/xm/dl.jsp").forward(request, response);
				return ;
			}
		}else {
			request.getRequestDispatcher("/xm/xgmm.jsp").forward(request, response);
			return ;
		}
	}

}
