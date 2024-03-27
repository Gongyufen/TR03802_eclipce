package saying;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/saying/insert")
public class Tj extends HttpServlet{
	private SayingDAO dd=new SayingDAO();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String user=request.getParameter("user");
		String content=request.getParameter("content");
		dd.insert(user, content);
		response.sendRedirect("insert.jsp");
	}
}
