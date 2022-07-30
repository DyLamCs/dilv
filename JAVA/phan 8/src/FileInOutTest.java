import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class FileInOutTest {
	Customer customer = new Customer();
	final String filename = ("c:/mydata/data.txt");

	public static void main(String[] args) {
		FileInOutTest run = new FileInOutTest();
//		run.testWriteToFile();
//		run.testReadFromFile();
//		run.addCustomer();
		run.listCustomer();
//		run.getCustomerByCode("1");
		
//		>>-----Chay xem ket qua cua viec cong danh so----<<
		
//		System.out.println(">>-----DS Khach Hang-----<<");
//		run.listCustomer();
//		run.increaseTurnover("2", 1);
//		System.out.println(">>-----DS Khach Hang sau khi cong doanhSo-----<<");
//		run.listCustomer();
//		>>------------------------------------------------<<
		
//		run.sortedCustomer();
//		run.VIPCustomer();
	}
// 	Phuong thuc VIPCustomer - In thông tin khách hàng có doanh số lớn nhất
	public void VIPCustomer() {
		ArrayList<Customer> alc = new ArrayList<Customer>();
		try {
			FileInputStream fis = new FileInputStream(filename);
			DataInputStream dis = new DataInputStream(fis);
			
			while(dis.available() > 0) {
				Customer customer = new Customer();
				customer.setMaKH(dis.readUTF());
				customer.setHoTen(dis.readUTF());
				customer.setDiaChi(dis.readUTF());
				customer.setDoanhSo(dis.readLong());
				
				alc.add(customer);
			}
//			MaKH kieu String -> Comparatoe.comparing
			alc.sort(Comparator.comparing(Customer::getDoanhSo).reversed());
//			reversed - dao nguoc chuoi vua sap xep
			
			System.out.println("Khach VIP *****");
			System.out.println(alc.get(0).toString());
			
			
			fis.close();
			dis.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	Phuong thuc sortedCustomer - In danh sách khách hàng theo thứ tự mã khách hàng tăng dần 	
	public void sortedCustomer() {
		ArrayList<Customer> alc = new ArrayList<Customer>();
		try {
			FileInputStream fis = new FileInputStream(filename);
			DataInputStream dis = new DataInputStream(fis);
			
			while(dis.available() > 0) {
				Customer customer = new Customer();
				customer.setMaKH(dis.readUTF());
				customer.setHoTen(dis.readUTF());
				customer.setDiaChi(dis.readUTF());
				customer.setDoanhSo(dis.readLong());
				
				alc.add(customer);
			}
//			MaKH kieu String -> Comparatoe.comparing
			alc.sort(Comparator.comparing(Customer::getMaKH));
			
			
			for (Customer customer : alc) {
				System.out.println(customer.toString());
			}
			fis.close();
			dis.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

// 	Phuong thuc increaseTurnover Cộng thêm sum vào doanhSo của khách hàng có  maKH
	public void increaseTurnover(String maKH, long sum) {
		boolean checkCustumer = false;
		ArrayList<Customer> alc = new ArrayList<Customer>();
		try {
			FileInputStream fis = new FileInputStream(filename);
			DataInputStream dis = new DataInputStream(fis);
			
//			System.out.println(">>-----------------<<");
			while(dis.available() > 0) {
				Customer customer = new Customer();
				customer.setMaKH(dis.readUTF());
				customer.setHoTen(dis.readUTF());
				customer.setDiaChi(dis.readUTF());
				customer.setDoanhSo(dis.readLong());
				
				if(customer.getMaKH().equals(maKH)) {
					checkCustumer = true;
					customer.setDoanhSo( sum + customer.getDoanhSo());
				}
				alc.add(customer);
			}
			if (!checkCustumer) {
				System.out.println("MaKH khong ton tai !");
			}else {
				reFreshFile(alc);
				
			}
			fis.close();
			dis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	reFreshFile - lam moi (GHI) tap  tin  voi  danh  sach  khach  hang  moi
	public void reFreshFile(ArrayList<Customer> alc) {
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			DataOutputStream dos = new DataOutputStream(fos);
			for (Customer customer : alc) {
				dos.writeUTF(customer.maKH);
				dos.writeUTF(customer.hoTen);
				dos.writeUTF(customer.diaChi);
				dos.writeLong(customer.doanhSo);
			}

			fos.close();
			dos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	Phuong thuc deleteCustomer xoa kh ra khoi tap tin file bang maKH
	public void deleteCustomer(String maKH) {

	}

// 	Phuong thuc getCustomerByCode in ra man hinh thong tin khach hang neu co
	public void getCustomerByCode(String maKH) {
		boolean checkMaKH = false;
		try {
			FileInputStream fos = new FileInputStream(filename);
			DataInputStream dos = new DataInputStream(fos);

			while (dos.available() > 0) {
				customer.setMaKH(dos.readUTF());
				customer.setHoTen(dos.readUTF());
				customer.setDiaChi(dos.readUTF());
				customer.setDoanhSo(dos.readLong());

				if (customer.getMaKH().equals(maKH)) {
					checkMaKH = true;
					System.out.println(customer.toString());
				}

			}
			if (checkMaKH == false)
				System.out.println("Khong tim thay maKH!");
			fos.close();
			dos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	Phuong thuc listCustomer - Liet ke danh sach khach hang co trong filename
	public void listCustomer() {
		try {
			FileInputStream fis = new FileInputStream(filename);
			DataInputStream dis = new DataInputStream(fis);


			while (dis.available() > 0) {
				customer.setMaKH(dis.readUTF());
				customer.setHoTen(dis.readUTF());
				customer.setDiaChi(dis.readUTF());
				customer.setDoanhSo(dis.readLong());

				System.out.println(customer.toString());
			}
			fis.close();
			dis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	Phương thức addCustomer - Nhap thong tin khach hang tu ban phim, luu vao filename
	public void addCustomer() {
		int choiceNumber;
		try {
			FileOutputStream fos = new FileOutputStream(filename, true);
			DataOutputStream dos = new DataOutputStream(fos);
			try (Scanner scanner = new Scanner(System.in)) {
				while (true) {
					System.out.println("----------------------------------------------");
					System.out.println("Nhap phim 1 de tiep tuc || An phim 2 de thoat!");
					System.out.println("----------------------------------------------");
					choiceNumber = scanner.nextInt();
					scanner.nextLine();
					if (choiceNumber == 1) {
						System.out.println("-----------------------------------------------------");
						System.out.println("Nhap thong tin khach hang || An 0 de in thong tin KH ");
						System.out.println("-----------------------------------------------------");
						System.out.print("Nhap maKH:");
						customer.maKH = scanner.nextLine();

						if (customer.getMaKH().equals("0")) {
							break;
						} else {

							System.out.print("Nhap hoTen: ");
							customer.hoTen = scanner.nextLine();

							System.out.print("Nhap diaChi:");
							customer.diaChi = scanner.nextLine();

							System.out.print("Nhap doanhSo:");
							customer.doanhSo = scanner.nextLong();

							scanner.nextLine();

//							khachHang.add(new Customer(customer.maKH, customer.hoTen, customer.diaChi, customer.doanhSo ));
							dos.writeUTF(customer.maKH);
							dos.writeUTF(customer.hoTen);
							dos.writeUTF(customer.diaChi);
							dos.writeLong(customer.doanhSo);
						}

					}
					if (choiceNumber == 2)
						System.exit(choiceNumber);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			fos.close();
			dos.close();
			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//	Phương thức testReadFromFile
	public void testReadFromFile() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filename);
			System.out.print("File Content: ");
			int ch = 0;
			while ((ch = fis.read()) != -1) {
				System.out.print((char) ch);
			}

			fis.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	Phương thức testWriteToFile
	public void testWriteToFile() {
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			DataOutputStream dos = new DataOutputStream(fos);

			InputStream inputStream = System.in;
			System.out.print("Moi ban nhap:");
			while (true) {
				int ch = inputStream.read();
				if (ch == '~') {
					break;
				} else
					dos.write(ch);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
