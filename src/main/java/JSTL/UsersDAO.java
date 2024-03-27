package JSTL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO {
	public List<Users> queryAll(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gyf?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
			PreparedStatement stmt=conn.prepareStatement("select * from yhb");
			ResultSet rs=stmt.executeQuery();
			List<Users> list = new ArrayList<>();
			while(rs.next()) {
				Users users=new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4));
				list.add(users);
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
	public static void main(String[] args) {
		System.out.println(new UsersDAO().queryAll());
	}
}
