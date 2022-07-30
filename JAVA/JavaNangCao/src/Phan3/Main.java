package Phan3;

/**
 *	Bài tập phần luồng xử lý bị trùng với phần exception nên anh cho bài tập phần Thread như sau:
	Cho một danh sách là họ tên các sinh viên
	Ví dụ: {“Nguyen Ngoc Lan”,”Duong Tien Nam”,”Ngo Anh Quan”,”Pham Van Duc”,”Tran Thi Ha”}
	Một danh sách khác là quê tương ứng của các sinh viên trên:
	Ví dụ:
	{“Hải Phòng”,”Hà Nội”,”Thái Nguyên”,”Hà Tĩnh”,”Quảng Ninh”}
 	Viết 1 ứng dụng Java sử dụng Thread để thực hiện công việc:
		- Thread thứ nhất sau mỗi giây sẽ hiển thị tên 1 người tương ứng trong danh sách tên
		- Thread thứ hai ngay sau đó sẽ hiển thị quê tương ứng của người đó
		- Hai Thread thực hiện mỗi thread 5 lần sẽ dừng lại
	Phải đảm bảo rằng Thread1 luôn được chạy trước rồi mới đến Thread2
 *
 */
public class Main {

	public static void main(String[] args) {
		ShareData shareData = new ShareData();
		Thread1 t1 = new Thread1(shareData);
		Thread2 t2 = new Thread2(shareData);
		Thread3 t3 = new Thread3(shareData);
		Thread4 t4 = new Thread4(shareData);
		
//		t1.setPriority(Thread.MAX_PRIORITY); // set độ ưu tiên cho luồng 1 chạy trước
//		t2.setPriority(Thread.MIN_PRIORITY);
		
		t2.start(); // cho luồng chạy
		t1.start();	
		t3.start();
		t4.start();
		
		
		
		
		
		
		
		


	}

}
