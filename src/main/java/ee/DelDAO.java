package ee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DelDAO extends BaseDAO{
	public List<Del> queryqq(String xm, String mm){
		String sql="select * from del where xm=? and mm=?";
		return this.executequery(sql,new Mapper<Del>() {
			@Override
			public List<Del> map(ResultSet rs) throws SQLException {
				List<Del> list=new ArrayList<Del>();
				while(rs.next()) {
					Del dd=new Del(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
					list.add(dd);
				}
				return list;
			}
		},xm,mm);
	}
	
	  public int insert(String xm,String mm,String dh,String dz,String tx) {
		  String sql="insert into del values(null,?,?,?,?,?)";
		  return this.execute(sql,xm,mm,dh,dz,tx);
	  }
	  public int update(String tx,int id) {
		  String sql="update del set tx=? where id=?";
		  return this.execute(sql,tx,id);
	  }
}
