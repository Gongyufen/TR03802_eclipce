package xm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class medDAO {
	public List<Medicine> cha(String count){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gyf?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
			String sql="SELECT * FROM medicine WHERE MONTH(medicine_time) = ?";
			PreparedStatement stmt=conn.prepareStatement(sql);
			List<Medicine> list=new ArrayList<Medicine>();
			stmt.setString(1,count);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				Medicine med=new Medicine();
				 med.setJlid(rs.getInt("jlid"));
				 med.setYhid(rs.getString("yhid"));
				 med.setMedtime(rs.getTimestamp("medicine_time"));
				 med.setBq(rs.getString("disease"));
				 med.setTxfs(rs.getString("txfs"));
				list.add(med);
			}
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
