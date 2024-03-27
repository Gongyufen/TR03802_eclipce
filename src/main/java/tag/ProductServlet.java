package tag;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JSTL.Users;
@WebServlet(urlPatterns = "/10/list")
public class ProductServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String curpageParam = request.getParameter("curpage");
		String pagesizeParam = request.getParameter("pagesize");
		int curpage = curpageParam == null ? 1 : Integer.parseInt(curpageParam);
		int pagesize= pagesizeParam == null ? 2 : Integer.parseInt(pagesizeParam);
		String keyword=request.getParameter("keyword");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gyf?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
			String sql="select * from yhb limit ?,?";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setInt(1,(curpage-1)*pagesize);
			stmt.setInt(2,pagesize);
			ResultSet rs=stmt.executeQuery();
			//转换成cost的list集合
			List<Users>list=new ArrayList<Users>();
			while(rs.next()) {
				list.add(new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getTimestamp(4)));
			}
			//获取表中的所有记录的条数
			sql="select count(*) from yhb";
			stmt=conn.prepareStatement(sql);
			ResultSet rs2=stmt.executeQuery();
			rs2.next();
			int total=rs2.getInt("count(*)");//总记录数
			//将数据保存到request中以便转发jsp显示
			request.setAttribute("list",list);
			request.setAttribute("total",total);
			sql="SELECT * FROM yhb WHERE yhpwd LIKE ?";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1,"%"+keyword+"%");
			ResultSet rs3=stmt.executeQuery();
			List<Users>list2=new ArrayList<Users>();
			while(rs.next()) {
				list2.add(new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getTimestamp(4)));
			}
			request.setAttribute("keyword",keyword);
			rs3.close();
			rs2.close();
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
		//转到jsp
		request.getRequestDispatcher("list.jsp?curpage=" + curpage).forward(request, response);
	}
}