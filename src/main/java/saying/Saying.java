package saying;

import java.sql.Timestamp;

public class Saying {
	private int sid;
	private String user;
	private String content;
	private Timestamp time;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public Saying(int sid, String user, String content, Timestamp time) {
		super();
		this.sid = sid;
		this.user = user;
		this.content = content;
		this.time = time;
	}
}
