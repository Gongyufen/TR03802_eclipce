package el;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cs
 */
@WebServlet("/cs")
public class cs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> list=new ArrayList<String>();
		list.add("株洲");
		list.add("长沙");
		list.add("上海");
		list.add("北京");
		list.add("深圳");
		request.setAttribute("list",list);
		request.getRequestDispatcher("/0115zy/zy4/cs.jsp").forward(request, response);
	}

}
