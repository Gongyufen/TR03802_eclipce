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
 * Servlet implementation class sj
 */
@WebServlet("/sj")
public class sj extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Iphone> list=new ArrayList<Iphone>();
		list.add(new Iphone("001", "iphone14","ii.jpg", 5999.00,"富士康","紫色","A15"));
		request.setAttribute("iphone",list);
		Iphone iphone=list.get(0);
		request.setAttribute("id",iphone.getId());
		request.setAttribute("name",iphone.getName());
		request.setAttribute("tp",iphone.getTp());
		request.setAttribute("jg",iphone.getJg());
		request.setAttribute("cd",iphone.getCd());
		request.setAttribute("ys",iphone.getYs());
		request.setAttribute("gg",iphone.getGg());
		request.getRequestDispatcher("/0115zy/zy3/sj.jsp").forward(request, response);
	}

}
