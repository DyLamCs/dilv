package Phan7;

import java.io.Serializable;

public class Employee implements Serializable {
	/**
	 * Để đánh dấu phiên bản của lớp này, moi lan ghi se ghi phien ban len file
	 * Kiểm tra phiên bản mỗi lần đọc và ghi, nếu k khớp thì sẽ quăng ra lỗi sai phiên bản
	 */
	private static final long serialVersionUID = 1L;
	// khai báo các thuộc tính
	public String name;
	public String address;
	
	/*SSN là  khi đối tượng được xếp thứ tự, nhưng bởi vì trường
	này là tạm thời (transient), giá trị này không được gửi tới luồng đầu ra.
	Trường SSN của đối tượng Employee được deserialize là 0.
	khong phan giai thuoc tinh do xuong*/
	
	public transient int SSN; 
	public int number;
	
	
	public Employee() {
		super();
	}


	public Employee(String name, String address, int sSN, int number) {
		super();
		this.name = name;
		this.address = address;
		SSN = sSN;
		this.number = number;
	}


	@Override
	public String toString() {
		return "Employee [name=" + name + ", address=" + address + ", SSN=" + SSN + ", number=" + number + "]";
	}


	public void mailCheck() {
		System.out.println("Gửi mail tới " + name + " " + address);
	}

}
