package el;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ee
 */
@WebServlet("/ee")
public class ee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Student> mm=new HashMap<String, Student>();
		mm.put("15722836475",new Student("1","笑笑","430*******1001","15722836475",18,"ee.jpg"));
		request.setAttribute("student",mm);
		Student ss=mm.get("15722836475");
		request.setAttribute("id",ss.getId());
		request.setAttribute("name",ss.getName());
		request.setAttribute("sfz",ss.getSfz());
		request.setAttribute("phone",ss.getPhone());
		request.setAttribute("age",ss.getAge());
		request.setAttribute("tx",ss.getTx());
		request.getRequestDispatcher("0115zy/zy1/xs.jsp").forward(request, response);
	}

}
