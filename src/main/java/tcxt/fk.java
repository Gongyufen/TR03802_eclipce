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
 * Servlet implementation class fk
 */
@WebServlet("/tcxt/fkgl")
public class fk extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cph=request.getParameter("cph");
		String ccqy=request.getParameter("xx");
		String lfsy=request.getParameter("xx2");
		String zt=request.getParameter("xx3");
		String yysj=request.getParameter("sj");
		Timestamp timestamp = Timestamp.valueOf(yysj);
		FkglDAO dd=new FkglDAO();
		List<Fkgl>list=dd.ss(cph, ccqy, lfsy, zt, timestamp);
		if (list != null && !list.isEmpty()) {
		    boolean isMatch = false;
		    for (Fkgl fkgl : list) {
		        if (cph.equals(fkgl.getCph().trim()) && ccqy.equals(fkgl.getQymc().trim()) 
		                && lfsy.equals(fkgl.getSy().trim()) && zt.equals(fkgl.getZt().trim())
		                && timestamp.equals(fkgl.getSqsj())) {
		            isMatch = true;
		            break;
		        }
		    }
		    if (isMatch) {
		        // 跳转到匹配成功页面
		        request.getRequestDispatcher("/tcxt/dhcx.jsp").forward(request, response);
		    } else {
		        // 跳转到匹配失败页面
		        request.getRequestDispatcher("/tcxt/zbd.jsp").forward(request, response);
		    }
		} else {
			 request.getRequestDispatcher("/tcxt/zbd.jsp").forward(request, response);
		}
	}
}
