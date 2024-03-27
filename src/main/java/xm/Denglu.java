package xm;

public class Denglu {
	private int id;
	private String zh;
	private String pwd;
	private String email;
	private String phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getZh() {
		return zh;
	}
	public void setZh(String zh) {
		this.zh = zh;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Denglu(int id, String zh, String pwd, String email, String phone) {
		super();
		this.id = id;
		this.zh = zh;
		this.pwd = pwd;
		this.email = email;
		this.phone = phone;
	}
	public Denglu() {
		super();
	}
	public Denglu(int id, String zh, String email, String phone) {
		super();
		this.id = id;
		this.zh = zh;
		this.email = email;
		this.phone = phone;
	}
	
}
