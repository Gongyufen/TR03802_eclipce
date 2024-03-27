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
 * Servlet implementation class stu
 */
@WebServlet("/stu")
public class stu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<Student> list = new ArrayList<>();
	        list.add(new Student("张三", "一班", 18, 80.5));
	        list.add(new Student("李四", "一班", 19, 90.0));
	        list.add(new Student("王五", "二班", 17, 58.3));
	        list.add(new Student("赵六", "二班", 18, 75.8));
	        list.add(new Student("钱七", "三班", 20, 92.5));
	        int age = 0;
	        double score = 0;
	        for (Student student : list) {
	            age += student.getAge();
	            score += student.getCj();
	        }
	        double pjage = age / 5;
	        double pjscore = score / 5;
	        request.setAttribute("list",list);
	        request.setAttribute("pjage",pjage);
	        request.setAttribute("pjscore",pjscore);
	        request.getRequestDispatcher("/0116zy/zy3/student.jsp").forward(request, response);
	}

}
