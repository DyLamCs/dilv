package Phan7;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Ghi object ra file
 *
 */
public class SerializeDemo {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		// Tạo danh sách mãng chứa các đối tượng của class Employee
		ArrayList<Employee> emplist = new ArrayList<Employee>();
//		// Khai 2 đối tượng mới của lớp Employee
//		Employee e = new Employee("Nguyen Van A", "Can Tho", 123, 5000);
//		Employee e1 = new Employee("Nguyen Van B", "Tp.Hcm", 124, 6000);
//		// Thêm 2 đối tượng vào danh sách
//		emplist.add(e);
//		emplist.add(e1);
		
		System.out.println("Bạn muốn nhập bao nhiêu đối tượng: ");
		int numObj = scanner.nextInt();
		scanner.nextLine();
		for (int i = 1; i <= numObj ; i++) {
			System.out.printf("Nhập thông tin người thứ %d:  \n", i );
			System.out.print("\tNhập vào tên: ");
			String name = scanner.nextLine();
			
			System.out.print("\tNhập vào địa chỉ: ");
			String adddress = scanner.nextLine();
			
			System.out.print("\tNhập vào SSN: ");
			int ssn = scanner.nextInt();
			
			System.out.print("\tNhập vào number: ");
			int num = scanner.nextInt();
			scanner.nextLine();
			Employee e = new Employee(name, adddress, ssn, num);
			emplist.add(e);
			
		}

		try {
			// ghi dữ liệu vào một file theo định dạng byte
			FileOutputStream fileOut = new FileOutputStream("C:/mydata/phan7/employee.ser");

			// được sử dụng để ghi các kiểu dữ liệu nguyên thuỷ và các đối tượng Java vào
			// một OutputStream.
			ObjectOutputStream out = new ObjectOutputStream(fileOut);

			// Lặp qua các đối tượng trong danh sách mãng và ghi đối tượng
			for (Employee employee : emplist) {
				out.writeObject(employee);
			}
			// Đóng ObjectOutputStream
			out.close();

			// Đóng FileOutputStream
			fileOut.close();

			System.out.printf("Du lieu da duoc serialize duoc luu giu trong C:/mydata/phan7/employee.ser");
		} catch (IOException i) {
			i.printStackTrace();
		}

	}
}
