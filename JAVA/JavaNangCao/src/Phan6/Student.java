package Phan6;

public class Student {
	int id, age;
	String name;

	/**
	 * Khởi tạo phương thức không đối số
	 */
	public Student() {

	}

	/**
	 * Khởi tạo phương thức với các đối số:
	 * 
	 * @param id
	 * @param age
	 * @param name
	 */
	public Student(int id, String name, int age) {
		this.id = id;
		this.age = age;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", age=" + age + ", name=" + name + "]";
	}

}
