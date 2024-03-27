package JSTLzy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class bd
 */
@WebServlet("/bd")
public class bd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String x[] =request.getParameterValues("hobby");
		List<String>list=new ArrayList<String>();
		for(String i:x) {
			list.add(i);
		}
		request.setAttribute("list",list);
		request.setAttribute("now",new Date());
		request.getRequestDispatcher("/0116zy/zy2/sc.jsp").forward(request, response);
	}

}
