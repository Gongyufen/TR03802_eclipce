package tr03802.zy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
@WebServlet(urlPatterns = "/dd")
public class Dlyz extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String text=request.getParameter("text");
		String pwd=request.getParameter("pwd");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ff?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root","123456");
			String sql="select * from yh where username=? and passwordd=?";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1, text);
			stmt.setString(2, pwd);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				String contextPath = request.getContextPath();
				response.sendRedirect(contextPath + "/0111zy/zy1/manager.jsp");
			}else {
				JOptionPane.showMessageDialog(null, "账户或密码错误");
				String path=request.getContextPath();
				response.sendRedirect(path+"/0111zy/zy1/dl.jsp");
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
