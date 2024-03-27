package saying;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class chart
 */
@WebServlet("/saying/chart")
public class chart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SayingDAO dd=new SayingDAO();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<ChartDCVO> list=dd.chart();
		//计算总数
		int total=0;
		for(ChartDCVO cc:list) {
			total+=cc.getCount();
		}
		request.setAttribute("total",total);
		request.setAttribute("list",list);
		request.getRequestDispatcher("chart.jsp").forward(request, response);
	}

}
