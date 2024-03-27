package news;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BaseDAO {
	//获取连接对象
	public Connection getconn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gyf?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8","root","123456");
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//释放资源
	public void close(ResultSet rs,Statement stmt,Connection conn) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//没有结果集的释放资源
	public void close(Statement stmt,Connection conn) {
		this.close(null, stmt, conn);
	}
	//绑定参数
	public void bangding(PreparedStatement stmt,Object...params) {
		if(params!=null) {
			for(int i=0;i<params.length;i++) {
				try {
					stmt.setObject(i+1, params[i]);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	//执行增删改操作
	public int execute(String sql,Object...params) {
		try {
			Connection conn=this.getconn();
			PreparedStatement stmt=conn.prepareStatement(sql);
			this.bangding(stmt, params);
			int v=stmt.executeUpdate();
			this.close(stmt, conn);
			return v;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	//执行查询的语句
	public <E> List<E> executequery(String sql,Mapper<E>mapper,Object...params){
		try {
			Connection conn=this.getconn();
			PreparedStatement stmt=conn.prepareStatement(sql);
			this.bangding(stmt, params);
			ResultSet rs=stmt.executeQuery();
			List<E> list=mapper.map(rs);
			this.close(rs, stmt, conn);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Object sing(String sql,Object...params) {
		List<Object> list=this.executequery(sql,new Mapper<Object>() {
			@Override
			public List<Object> map(ResultSet rs) throws SQLException {
				List<Object> list=new ArrayList<Object>();
				while(rs.next()) {
					Object obj=rs.getObject(1);
					list.add(obj);
				}
				return list;
			}
		}, params);
		return list.get(0);
	}
}
