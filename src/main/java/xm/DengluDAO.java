package xm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DengluDAO {
	public List<Denglu> cha(String zh,String pwd){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gyf?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
			String sql="select * from working where zh=? and pwd=?";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1,zh);
			stmt.setString(2,pwd);
			ResultSet rs=stmt.executeQuery();
			List<Denglu> list=new ArrayList<Denglu>();
			if(rs.next()) {
				Denglu dl=new Denglu();
				dl.setZh(rs.getString("zh"));
				dl.setPwd(rs.getString("pwd"));
				list.add(dl);
			}
			rs.close();
			stmt.close();
			conn.close();
			return list;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
