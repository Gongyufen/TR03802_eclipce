package JSTL;

import java.sql.Timestamp;

public class Users {
	private int uid;
	private String name;
	private String pwd;
	private Timestamp zc;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Timestamp getZc() {
		return zc;
	}
	public void setZc(Timestamp zc) {
		this.zc = zc;
	}
	public Users(int uid, String name, String pwd, Timestamp timestamp) {
		super();
		this.uid = uid;
		this.name = name;
		this.pwd = pwd;
		this.zc = timestamp;
	}
	public Users() {
		super();
	}
	
}
