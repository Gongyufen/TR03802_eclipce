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
@WebServlet (urlPatterns = "/yy")
public class Zcyz extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String text=request.getParameter("text");
		String pwd=request.getParameter("pwd");
		String name=request.getParameter("name");
		String tel=request.getParameter("tel");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ff?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root","123456");
			String sql2="select * from yh where nickname=?";
			PreparedStatement stmt2=conn.prepareStatement(sql2);
			stmt2.setString(1, name);
			ResultSet rs=stmt2.executeQuery();
			if(rs.next()) {
				JOptionPane.showConfirmDialog(null,"昵称重复了，请换一个名称");
				String path=request.getContextPath();
				response.sendRedirect(path+"/0111zy/zy1/zc.jsp");
			}else {
				String sql="insert into yh values(null,?,?,?,?)";
				PreparedStatement stmt=conn.prepareStatement(sql);
				stmt.setString(1, name);
				stmt.setString(2, text);
				stmt.setString(3, pwd);
				stmt.setString(4, tel);
				stmt.executeUpdate();
				stmt.close();
				conn.close();
			}
			rs.close();
			stmt2.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
