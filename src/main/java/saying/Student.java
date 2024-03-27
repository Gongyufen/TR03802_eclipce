package saying;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Student {
	private int id;
	private String name;
	private String sex;
	private String phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Student(int id, String name, String sex, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
	}
	public Student() {
		super();
	}
	public static void main(String[] args) {
		Student s=new Student(1,"滴滴","男","19228328836");
		Student s2=new Student(2,"滴滴","男","19228328836");
		//对象
		System.out.println(JSONObject.toJSONString(s));
		//集合
		List<Student> list=new ArrayList<Student>();
		list.add(s);
		list.add(s2);
		System.out.println(JSONArray.toJSONString(list));
	}
}
