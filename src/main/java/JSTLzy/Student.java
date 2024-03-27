package JSTLzy;

public class Student {
	private String name;
	private String bj;
	private int age;
	private double cj;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBj() {
		return bj;
	}
	public void setBj(String bj) {
		this.bj = bj;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getCj() {
		return cj;
	}
	public void setCj(double cj) {
		this.cj = cj;
	}
	public Student(String name, String bj, int age, double cj) {
		super();
		this.name = name;
		this.bj = bj;
		this.age = age;
		this.cj = cj;
	}
	public Student() {
		super();
	}
	
}
