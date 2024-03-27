package saying;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SayingDAO2 extends BaseDAO {
	/**
	 * 添加留言
	 */
	public int save(String user,String content) {
		String sql="insert into saying(suser,scontent,stime)values(?,?,now())";
		return this.execute(sql,user,content);
	}
	/**
	 * 更新留言
	 * @param sid
	 * @param user
	 * @param content
	 * @return
	 * @param args
	 */
	public int update(int sid,String user,String content) {
		String sql="update saying set suser=?,scontent=? where sid=?";
		return this.execute(sql,user,content,sid);
	}
	/**
	 * 删除留言
	 * @param sid
	 * @return
	 * @param args
	 */
	public int delete(int sid) {
		String sql="delete from saying where sid=?";
		return this.execute(sql,sid);
	}
	/**
	 * 查询所有留言
	 * @return
	 * @param args
	 */
	public List<Saying> query(){
		String sql="select * from saying order by sid desc";
		return this.executequery(sql,new Mapper<Saying>() {
			@Override
			public List<Saying> map(ResultSet rs) throws SQLException {
				List<Saying> list=new ArrayList<Saying>();
				while(rs.next()) {
					Saying saying=new Saying(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getTimestamp(4));
					list.add(saying);
				}
				return list;
			}
		});
	}
	/**
	 * 统计
	 * @param args
	 */
	public List<ChartDCVO>chart(){
		String sql="select DATE_FORMAT(stime,'%Y-%m-%d')d,count(*)c from saying group by DATE_FORMAT(stime,'%Y-%m-%d')";
		return this.executequery(sql,new Mapper<ChartDCVO>() {
			@Override
			public List<ChartDCVO> map(ResultSet rs) throws SQLException {
				List<ChartDCVO>list=new ArrayList<ChartDCVO>();
				while(rs.next()) {
					ChartDCVO cc=new ChartDCVO(rs.getDate("d"),rs.getInt("c"));
					list.add(cc);
				}
				return list;
			}
		});
	}
	/**
	 * 分页查询
	 * @param args
	 */
	public Map<String,Object>queryByPage(int curpage,int pagesize){
		String sql="select * from saying order by sid desc limit ?,?";
		List<Saying>list=this.executequery(sql,new Mapper<Saying>() {
			@Override
			public List<Saying> map(ResultSet rs) throws SQLException {
				List<Saying> list=new ArrayList<Saying>();
				while(rs.next()) {
					Saying ss=new Saying(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getTimestamp(4));
					list.add(ss);
				}
				return list;
			}
		},(curpage-1)*pagesize,pagesize);
		String sql2="select count(*)c from saying";
		Object obj=this.singObject(sql2);
		Map<String,Object>map=new HashMap<String, Object>();
		map.put("list",list);
		map.put("total",obj);
		return map;
	}
	public static void main(String[] args) {
		SayingDAO2 dd=new SayingDAO2();
		//dd.save("小黄","我们难忘的那年");
		//dd.update(8,"小猫咪","湖南小猫咪");
		//dd.delete(6);
		//System.out.println(dd.query());
		//System.out.println(dd.chart());
		Map<String,Object>map=dd.queryByPage(1,2);
		System.out.println(map.get("list"));
		System.out.println(map.get("total"));
	}
}
