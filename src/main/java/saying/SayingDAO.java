package saying;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SayingDAO {
	/**
	 * 单行删除
	 */
	public void delete(String sid){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gyf?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8","root","123456");
			String sql="delete from saying where sid=?";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1,sid);
			stmt.executeUpdate();
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
	/**
	 * 批量删除留言
	 * @param sids
	 */
	public void deleted(String[]sids){
		if(sids==null)return;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gyf?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8","root","123456");
			PreparedStatement stmt=null;
			String sql="delete from saying where sid=?";
			for(String sid:sids) {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1,sid);
			stmt.executeUpdate();
			}
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
	/**
	 * 留言
	 * @param user 用户名
	 * @param content 留言内容
	 */
	public void insert(String user,String content){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gyf?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8","root","123456");
			String sql="insert into saying(suser,scontent,stime)values(?,?,now())";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1,user);
			stmt.setString(2,content);
			stmt.executeUpdate();
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
	/**
	 * 分页查询留言
	 * @return
	 */
	public Map<String, Object> queryByPage(int curpage,int pagesize){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gyf?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8","root","123456");
			String sql="select * from saying  order by sid desc limit ?,?";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setInt(1,(curpage-1)*pagesize);
			stmt.setInt(2, pagesize);
			ResultSet rs=stmt.executeQuery();
			List<Saying> list=this.map(rs);
			//将list添加到map集合中
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("list",list);
			//计算总的记录数
			sql="select count(*) from saying";
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			rs.next();
			int total=rs.getInt(1);
			map.put("total",total);
			rs.close();
			stmt.close();
			conn.close();
			return map;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 查询留言列表
	 * @return
	 */
	public List<Saying> query(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gyf?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8","root","123456");
			String sql="select * from saying order by sid desc";
			PreparedStatement stmt=conn.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			List<Saying> list=this.map(rs);
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
	/**
	 * 将ResultSet转换成List
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private List<Saying> map(ResultSet rs) throws SQLException{
		List<Saying> list=new ArrayList<Saying>();
		while(rs.next()) {
			Saying saying=new Saying(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getTimestamp(4));
			list.add(saying);
		}
		return list;
	}
	/**
	 * 统计每日留言数
	 * @return
	 */
	public List<ChartDCVO> chart(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gyf?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8","root","123456");
			String sql="select DATE_FORMAT(stime,'%Y-%m-%d')d,count(*)c from saying group by DATE_FORMAT(stime,'%Y-%m-%d')";
			PreparedStatement stmt=conn.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			List<ChartDCVO> list=new ArrayList<ChartDCVO>();
			while(rs.next()) {
				ChartDCVO cc=new ChartDCVO(rs.getDate("d"),rs.getInt("c"));
				list.add(cc);
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
		SayingDAO dd=new SayingDAO();
		dd.insert("张三","小猫怎么叫？喵喵喵");
	}
}
