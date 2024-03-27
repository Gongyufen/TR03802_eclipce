package tcxt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FkglDAO {
	public List<Fkgl> chaxun(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gyf?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
			String sql="select * from che";
			PreparedStatement stmt=conn.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			List<Fkgl> list=new ArrayList<Fkgl>();
			while(rs.next()) {
				Fkgl ff=new Fkgl();
				ff.setCid(rs.getInt("cid"));
				ff.setCph(rs.getString("cph"));
				ff.setPhone(rs.getString("phone"));
				ff.setSy(rs.getString("sy"));
				ff.setQymc(rs.getString("qymc"));
				ff.setSqsj(rs.getTimestamp("sqsj"));
				ff.setKssj(rs.getTimestamp("kssj"));
				ff.setJssj(rs.getTimestamp("jssj"));
				ff.setZt(rs.getString("zt"));
				ff.setBz(rs.getString("bz"));
				list.add(ff);
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
	public List<Fkgl> ss(String cph,String xx,String xx2,String xx3,Timestamp sj){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gyf?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
			String sql="SELECT * FROM che WHERE cph = ? AND qymc = ? AND sy = ? AND zt = ? AND sqsj = ?";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1,cph);
			stmt.setString(2,xx);
			stmt.setString(3,xx2);
			stmt.setString(4,xx3);
			stmt.setTimestamp(5,sj);
			ResultSet rs=stmt.executeQuery();
			List<Fkgl> list=new ArrayList<Fkgl>();
			while(rs.next()) {
				Fkgl ff=new Fkgl();
				ff.setCph(rs.getString("cph"));
	            ff.setSy(rs.getString("sy"));
	            ff.setQymc(rs.getString("qymc"));
	            ff.setSqsj(rs.getTimestamp("sqsj"));
	            ff.setZt(rs.getString("zt"));
				 if (cph.equals(ff.getCph().trim()) && xx.equals(ff.getQymc()) && xx2.equals(ff.getSy())
				            && xx3.equals(ff.getZt()) && sj.equals(ff.getSqsj())) {
				            list.add(ff);
				        }
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
	public List<Fkgl> cr(String cph,String sjh,Timestamp sqsj,Timestamp kssj,Timestamp jssj,String lfsy,String qymc,String zt,String bz){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gyf?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
			String sql="insert into che values(null,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1,cph);
			stmt.setString(2,sjh);
			stmt.setString(3,lfsy);
			stmt.setString(4,qymc);
			stmt.setTimestamp(5,sqsj);
			stmt.setTimestamp(6,kssj);
			stmt.setTimestamp(7,jssj);
			stmt.setString(8,zt);
			stmt.setString(9,bz);
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
		return null;
	}
	public List<Fkgl> sc(String cph){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gyf?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
			String sql="delete from che where cid=?";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1,cph);
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
		return null;
	}
	private List<Fkgl> map(ResultSet rs) throws SQLException{
		List<Fkgl> list=new ArrayList<Fkgl>();
		while(rs.next()) {
			Fkgl ff=new Fkgl(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getTimestamp(6),rs.getTimestamp(7),rs.getTimestamp(8),rs.getString(9),rs.getString(10));
			list.add(ff);
		}
		return list;
	}
	/**
	 * 分页查询留言
	 * @return
	 */
	public Map<String, Object> queryByPage(int curpage,int pagesize){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gyf?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8","root","123456");
			String sql="select * from che  order by cid desc limit ?,?";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setInt(1,(curpage-1)*pagesize);
			stmt.setInt(2, pagesize);
			ResultSet rs=stmt.executeQuery();
			List<Fkgl> list=this.map(rs);
			//将list添加到map集合中
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("list",list);
			//计算总的记录数
			sql="select count(*) from che";
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
}
