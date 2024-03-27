package el;

public class Iphone {
	private String id;
	private String name;
	private String tp;
	private double jg;
	private String cd;
	private String ys;
	private String gg;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTp() {
		return tp;
	}
	public void setTp(String tp) {
		this.tp = tp;
	}
	public double getJg() {
		return jg;
	}
	public void setJg(double jg) {
		this.jg = jg;
	}
	public String getCd() {
		return cd;
	}
	public void setCd(String cd) {
		this.cd = cd;
	}
	public String getYs() {
		return ys;
	}
	public void setYs(String ys) {
		this.ys = ys;
	}
	public String getGg() {
		return gg;
	}
	public void setGg(String gg) {
		this.gg = gg;
	}
	public Iphone(String id, String name, String tp, double jg, String cd, String ys, String gg) {
		super();
		this.id = id;
		this.name = name;
		this.tp = tp;
		this.jg = jg;
		this.cd = cd;
		this.ys = ys;
		this.gg = gg;
	}
	public Iphone() {
		super();
	}
	
}
