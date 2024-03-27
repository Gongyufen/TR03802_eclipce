package xm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Gerenxinxi {
	public List<Denglu> all(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gyf?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
			String sql="select id,zh,email,phone from working";
			PreparedStatement stmt=conn.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			List<Denglu> list=new ArrayList<Denglu>();
			while(rs.next()) {
				Denglu dl=new Denglu(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
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
