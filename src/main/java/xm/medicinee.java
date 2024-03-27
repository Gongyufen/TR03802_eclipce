package xm;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class medicinee
 */
@WebServlet("/medicinee")
public class medicinee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MedicineDAO med=new MedicineDAO();
		List<Medicine> list=med.all();
		request.setAttribute("list",list);
		if(list!=null) {
			request.getRequestDispatcher("/xm/med.jsp").forward(request, response);
		}
	}

}
