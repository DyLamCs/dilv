package Phan6;

import java.util.ArrayList;

public class PersonModel <T>{
	ArrayList<T> aL = new ArrayList<T>();
	
	public void add(T obj) {
		aL.add(obj);
	}
	
	public void display() {
		for (T i : aL) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		// Tạo đối tượng PersonModel<Student>
		PersonModel<Student> student = new PersonModel<Student>();
		student.add(new Student(01, "Nguyen Van A", 18));
		student.add(new Student(02, "Nguyen Van B", 18));
		student.display();
		System.out.println("---------------");
		
		//Tạo đối tượng PersonModel<Employee>
		PersonModel<Employee> emplyee = new PersonModel<Employee>();
		emplyee.add(new Employee("NV01", "Nguyen Van A", "5000$"));
		emplyee.add(new Employee("NV02", "Nguyen Van B", "5000$"));
		emplyee.display();
		System.out.println("---------------");
		
		//Tạo đối tượng PersonModel<String>
		PersonModel<String> strPersonModel = new PersonModel<String>();
		strPersonModel.add("Nguyen Van A");
		strPersonModel.add("Nguyen Van B");
		strPersonModel.display();

	}

	

	

}
