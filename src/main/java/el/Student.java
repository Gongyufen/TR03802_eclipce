package el;

public class Student {
	private String id;
	private String name;
	private String sfz;
	private String phone;
	private int age;
	private String tx;
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
	public String getSfz() {
		return sfz;
	}
	public void setSfz(String sfz) {
		this.sfz = sfz;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTx() {
		return tx;
	}
	public void setTx(String tx) {
		this.tx = tx;
	}
	public Student(String id, String name, String sfz, String phone, int age, String tx) {
		super();
		this.id = id;
		this.name = name;
		this.sfz = sfz;
		this.phone = phone;
		this.age = age;
		this.tx = tx;
	}
	public Student() {
		super();
	}
}
