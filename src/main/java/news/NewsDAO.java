package news;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsDAO extends BaseDAO{
	//发布新闻
	public int fb(String bt,String ly) {
		String sql="insert into news(bt,ly,fbsj)values(?,?,now())";
		return this.execute(sql,bt,ly);
	}
	//分页浏览新闻标题
	public Map<String,Object> querybupage(int curpage,int pagesize){
		String sql="select bt from news order by id desc limit ?,?";
		List<News> list=this.executequery(sql,new Mapper<News>() {
			@Override
			public List<News> map(ResultSet rs) throws SQLException {
				List<News>list=new ArrayList<News>();
				while(rs.next()) {
					News nn=new News();
					list.add(nn);
				}
				return list;
			}
		},(curpage-1)*pagesize,pagesize);
		String sql2="select count(*) from news";
		Object obj=this.sing(sql2);
		Map<String,Object>map=new HashMap<String, Object>();
		map.put("list",list);
		map.put("total",obj);
		return map;
	}
	//查看新闻详情
	public List<News> query(){
		String sql="select * from news";
		return this.executequery(sql,new Mapper<News>() {
			@Override
			public List<News> map(ResultSet rs) throws SQLException {
				List<News>list=new ArrayList<News>();
				while(rs.next()) {
					News nn=new News(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getTimestamp(4));
					list.add(nn);
				}
				return list;
			}
		});
	}
	//删除一个月以前的新闻
	public int delete() {
		String sql="DELETE FROM news WHERE fbsj < DATE_SUB(NOW(), INTERVAL 1 MONTH)";
		return this.execute(sql);
	}
	public static void main(String[] args) {
		NewsDAO nn=new NewsDAO();
		//nn.fb("龚玉芬","花果山");
		/*
		 * Map<String,Object>map=nn.querybupage(1,3);
		 * System.out.println(map.get("list")); System.out.println(map.get("total"));
		 */
		//System.out.println(nn.query());
		nn.delete();
	}
}
