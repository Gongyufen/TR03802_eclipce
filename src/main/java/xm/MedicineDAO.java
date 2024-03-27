package xm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineDAO {
	public List<Medicine> all(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gyf?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
			String sql="select * from medicine";
			PreparedStatement stmt=conn.prepareStatement(sql);
			List<Medicine> list=new ArrayList<Medicine>();
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				Medicine mm=new Medicine(rs.getInt(1),rs.getString(2),rs.getTimestamp(3),rs.getString(4),rs.getString(5));
				list.add(mm);
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
