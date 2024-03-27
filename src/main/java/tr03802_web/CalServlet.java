package tr03802_web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalServlet
 */
@WebServlet("/CalServlet")
public class CalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a=Integer.parseInt(request.getParameter("a"));
		int b=Integer.parseInt(request.getParameter("b"));
		String o=request.getParameter("o");
		double r=0;
		if(o.equals("+")) {
			r=a+b;
		}else if(o.equals("-")) {
			r=a-b;
		}else if(o.equals("*")) {
			r=a*b;
		}else if(o.equals("/")) {
			r=a/b;
		}else if(o.equals("%")) {
			r=a%b;
		}
		request.setAttribute("a", a);
		request.setAttribute("b", b);
		request.setAttribute("o", o);
		request.setAttribute("r", r);
		request.getRequestDispatcher("7/jsq.jsp").forward(request, response);
	}
}
