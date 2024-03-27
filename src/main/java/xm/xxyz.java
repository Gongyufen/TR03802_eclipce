package xm;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class xxyz
 */
@WebServlet("/xxyz")
public class xxyz extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Gerenxinxi gr=new Gerenxinxi();
		    List<Denglu> list=gr.all();
		    if(list!=null) {
		        request.setAttribute("list",list);
		        try {
		            request.getRequestDispatcher("/xm/xinxi.jsp").forward(request, response);
		            return ;
		        } catch (ServletException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
	}
}
