package Phan7;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Đọc object từ file
 *
 */
public class DeserializeDemo {
	public static void main(String[] args) {
		Employee e = null;
		ArrayList<Employee> emplist = new ArrayList<Employee>();
		boolean check = true;

		try {
			// Đọc dữ liệu vào một file theo định dạng byte
			FileInputStream fileIn = new FileInputStream("C:/mydata/phan7/employee.ser");

			// được sử dụng để đọc các kiểu dữ liệu nguyên thuỷ và các đối tượng Java vào
			// một OutputStream.
			ObjectInputStream in = new ObjectInputStream(fileIn);

			while (check) {
				if (fileIn.available() != 0) {
					e = (Employee) in.readObject();
					emplist.add(e);
				} else {
					check = false;
				}

			}

			in.close();
			fileIn.close();
			
			// Lặp các đối tượng có trong mãng và in ra
			System.out.println("THÔNG TIN CÁC ĐỐI TƯỢNG ĐÃ NHẬP VÀO");
			System.out.println("-------------");
			
			for (Employee employee : emplist) {
				System.out.println("Name: " + employee.name);
				System.out.println("Address: " + employee.address);
				System.out.println("SSN: " + employee.SSN);
				System.out.println("Number: " + employee.number);
				System.out.println("-------------");
			}
		} catch (IOException i) {
			System.out.println("Loi phien ban");
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Khong tim thay lop Employee");
			c.printStackTrace();
			return;
		}

	}

}
