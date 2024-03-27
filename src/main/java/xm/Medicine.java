package xm;

public class Medicine {
	private int jlid;
	private String yhid;
	private java.sql.Timestamp medtime;
	private String bq;
	private String txfs;
	public int getJlid() {
		return jlid;
	}
	public void setJlid(int jlid) {
		this.jlid = jlid;
	}
	public String getYhid() {
		return yhid;
	}
	public void setYhid(String yhid) {
		this.yhid = yhid;
	}
	public java.sql.Timestamp getMedtime() {
		return medtime;
	}
	public void setMedtime(java.sql.Timestamp medtime) {
		this.medtime = medtime;
	}
	public String getBq() {
		return bq;
	}
	public void setBq(String bq) {
		this.bq = bq;
	}
	public String getTxfs() {
		return txfs;
	}
	public void setTxfs(String txfs) {
		this.txfs = txfs;
	}
	public Medicine(int jlid, String yhid, java.sql.Timestamp timestamp, String bq, String txfs) {
		super();
		this.jlid = jlid;
		this.yhid = yhid;
		this.medtime = timestamp;
		this.bq = bq;
		this.txfs = txfs;
	}
	public Medicine() {
		super();
	}
	
}
