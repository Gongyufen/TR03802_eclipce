package tcxt;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class fkdj
 */
@WebServlet("/tcxt/fkdj")
public class fkdj extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cph=request.getParameter("cc");
		String sjh=request.getParameter("ss");
		String sqsj=request.getParameter("sq");
		Timestamp time3 = Timestamp.valueOf(sqsj);
		String kssj=request.getParameter("kk");
		Timestamp time1 = Timestamp.valueOf(kssj);
		String jssj=request.getParameter("jj");
		Timestamp time2 = Timestamp.valueOf(jssj);
		String lfsy=request.getParameter("ll");
		String qymc=request.getParameter("qq");
		String zt=request.getParameter("zz");
		String bz=request.getParameter("bb");
		FkglDAO ff=new FkglDAO();
		List<Fkgl>list=ff.cr(cph, sjh, time3, time1, time2, lfsy, qymc, zt, bz);
		if(list==null) {
			request.getRequestDispatcher("/tcxt/fkgl.jsp").forward(request, response);
			return ;
		}else {
			request.getRequestDispatcher("/tcxt/fkgl.jsp").forward(request, response);
			return ;
		}
	}

}
