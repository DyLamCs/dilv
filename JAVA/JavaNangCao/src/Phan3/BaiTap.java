package Phan3;

import java.util.Arrays;
import java.util.List;

/**
 * Bài tập đồng bộ luồng
 *
 */
public class BaiTap {
	
	//Tạo 2 list chứa thông tin tên & địa chỉ
	
	List<String> nameList = Arrays.asList("Nguyen Ngoc Lan", "Duong Tien Nam", "Ngo Anh Quan",
			"Pham Van Duc", "Tran Thi Ha");
	
	List<String> addressList = Arrays.asList("Hải Phòng", "Hà Nội", "Thái Nguyên", "Hà Tĩnh", "Quảng Ninh"); 
	
	
	/**
	 * Phương thức đồng bộ hóa khi in tên
	 */
	public synchronized void showName () {
		for (int i = 0; i < nameList.size(); i++) {
			System.out.println("Name: " + nameList.get(i));
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			notify();
		}
	}
	
	/**
	 * Phương thức đồng bộ hóa khi in địa chỉ
	 */
	public synchronized void showAdress() {
		for (String addressList : addressList) {
			System.out.println("Address: " + addressList + "\n");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			notify();
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	public static void main(String[] args) {
		BaiTap baitap = new BaiTap();
		
		Thread t1 = new Thread() { //Tạo luồng thứ 1 để in ra tên
			public void run() {
				baitap.showName();
			}
		};
		
		t1.start(); // chạy luồng 1
		
		Thread t2 = new Thread() { //Tạo luông thứ 2 để in ra địa chỉ
			public void run() {
				baitap.showAdress();
			}
		};
		
		t2.start(); // chạy luồng 2
				
	}

}
