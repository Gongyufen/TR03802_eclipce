package news;

import java.sql.Timestamp;

public class News {
	private int id;
	private String bt;
	private String ly;
	private Timestamp fbsj;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBt() {
		return bt;
	}
	public void setBt(String bt) {
		this.bt = bt;
	}
	public String getLy() {
		return ly;
	}
	public void setLy(String ly) {
		this.ly = ly;
	}
	public Timestamp getFbsj() {
		return fbsj;
	}
	public void setFbsj(Timestamp fbsj) {
		this.fbsj = fbsj;
	}
	public News(int id, String bt, String ly, Timestamp fbsj) {
		super();
		this.id = id;
		this.bt = bt;
		this.ly = ly;
		this.fbsj = fbsj;
	}
	public News() {
		super();
	}
	
}
