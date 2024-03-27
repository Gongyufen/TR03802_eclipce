package JSTLzy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class huawei
 */
@WebServlet("/huawei")
public class huawei extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Phone> list=new ArrayList<Phone>();
		list.add(new Phone("001","HUAWEI mate 50",3999,"hw.jpg","好用好看",1999,0.8));
		list.add(new Phone("002","HUAWEI mate 50",3999,"hw.jpg","好用好看",1999,0.8));
		list.add(new Phone("003","HUAWEI mate 50",3999,"hw.jpg","好用好看",1999,0.8));
		list.add(new Phone("004","HUAWEI mate 60",5999,"hw2.jpg","好用好看",3999,0.9));
		list.add(new Phone("005","HUAWEI mate 60",5999,"hw2.jpg","好用好看",3999,0.9));
		list.add(new Phone("006","HUAWEI mate 60",5999,"hw2.jpg","好用好看",3999,0.9));
		request.setAttribute("list",list);
		request.getRequestDispatcher("/0116zy/zy4/sj.jsp").forward(request, response);
	}

}
