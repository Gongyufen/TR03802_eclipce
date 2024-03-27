package tcxt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ZhdlDAO {
	public List<Zhdl> cha(String zh,String mm){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gyf?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
			String sql="select * from zhdl where zh=? and mm=?";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1,zh);
			stmt.setString(2,mm);
			ResultSet rs=stmt.executeQuery();
			List<Zhdl> list=new ArrayList<Zhdl>();
			if(rs.next()) {
				Zhdl zz=new Zhdl();
				zz.setZh(rs.getString("zh"));
				zz.setMm(rs.getString("mm"));
				list.add(zz);
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
