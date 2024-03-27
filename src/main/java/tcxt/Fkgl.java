package tcxt;

import java.sql.Timestamp;

public class Fkgl {
	private int cid;
	private String cph;
	private String phone;
	private String sy;
	private String qymc;
	private Timestamp sqsj;
	private Timestamp kssj;
	private Timestamp jssj;
	private String zt;
	private String bz;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCph() {
		return cph;
	}
	public void setCph(String cph) {
		this.cph = cph;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSy() {
		return sy;
	}
	public void setSy(String sy) {
		this.sy = sy;
	}
	public String getQymc() {
		return qymc;
	}
	public void setQymc(String qymc) {
		this.qymc = qymc;
	}
	public Timestamp getSqsj() {
		return sqsj;
	}
	public void setSqsj(Timestamp sqsj) {
		this.sqsj = sqsj;
	}
	public Timestamp getKssj() {
		return kssj;
	}
	public void setKssj(Timestamp kssj) {
		this.kssj = kssj;
	}
	public Timestamp getJssj() {
		return jssj;
	}
	public void setJssj(Timestamp jssj) {
		this.jssj = jssj;
	}
	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		this.zt = zt;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public Fkgl(int cid, String cph, String phone, String sy, String qymc, Timestamp sqsj, Timestamp kssj,
			Timestamp jssj, String zt, String bz) {
		super();
		this.cid = cid;
		this.cph = cph;
		this.phone = phone;
		this.sy = sy;
		this.qymc = qymc;
		this.sqsj = sqsj;
		this.kssj = kssj;
		this.jssj = jssj;
		this.zt = zt;
		this.bz = bz;
	}
	public Fkgl() {
		super();
	}
	
	
}
