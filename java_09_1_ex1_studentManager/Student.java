package java_09_1_ex1_studentManager;

public class Student {
	private final int key;
	private String name;
	private int age;
	private String major;
	Student(int key, String name, int age, String major) {
		this.key = key;
		this.name = name;
		this.age = age;
		this.major = major;
	}
	public int getKey() {return key;}
	public String getName() {return name;}
	public int getAge() {return age;}
	public String getMajor() {return major;}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setMajor(String major) {
		this.major = major;
	}
}
