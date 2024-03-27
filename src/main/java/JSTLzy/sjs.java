package JSTLzy;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class sjs
 */
@WebServlet("/sjs")
public class sjs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Random random=new Random();
		int sj=random.nextInt(100)+1;
		 request.setAttribute("sj",sj);
		  request.getRequestDispatcher("/0116zy/zy1/cj.jsp").forward(request,
		  response); 
	}
}
