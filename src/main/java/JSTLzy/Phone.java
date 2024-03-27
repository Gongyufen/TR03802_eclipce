package JSTLzy;

public class Phone {
	private String id;
	private String name;
	private double price;
	private String src;
	private String ms;
	private int pjrs;
	private double hpd;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getMs() {
		return ms;
	}
	public void setMs(String ms) {
		this.ms = ms;
	}
	public int getPjrs() {
		return pjrs;
	}
	public void setPjrs(int pjrs) {
		this.pjrs = pjrs;
	}
	public double getHpd() {
		return hpd;
	}
	public void setHpd(double hpd) {
		this.hpd = hpd;
	}
	public Phone(String id, String name, double price, String src, String ms, int pjrs, double hpd) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.src = src;
		this.ms = ms;
		this.pjrs = pjrs;
		this.hpd = hpd;
	}
	public Phone() {
		super();
	}
	
}
