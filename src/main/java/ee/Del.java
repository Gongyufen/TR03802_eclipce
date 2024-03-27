package ee;

public class Del {
	private int id;
	private String xm;
	private String mm;
	private String dh;
	private String dz;
	private String tx;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getMm() {
		return mm;
	}
	public void setMm(String mm) {
		this.mm = mm;
	}
	public String getDh() {
		return dh;
	}
	public void setDh(String dh) {
		this.dh = dh;
	}
	public String getDz() {
		return dz;
	}
	public void setDz(String dz) {
		this.dz = dz;
	}
	public String getTx() {
		return tx;
	}
	public void setTx(String tx) {
		this.tx = tx;
	}
	public Del(int id, String xm, String mm, String dh, String dz, String tx) {
		super();
		this.id = id;
		this.xm = xm;
		this.mm = mm;
		this.dh = dh;
		this.dz = dz;
		this.tx = tx;
	}
	public Del() {
		super();
	}
	
}
