package Phan5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class DemoCheckedException {

	/**
	 * Báo hiệu rằng nỗ lực mở tệp được biểu thị bằng tên đường dẫn đã chỉ định đã không thành công.
	 */
	@SuppressWarnings("unused")
	public void testFileNotFoundException() {
		FileInputStream fileInput = null;
		
			try {
				fileInput = new FileInputStream("C:/mydata/phan5/test221.txt");
			} catch (FileNotFoundException e) {
				System.err.println(e);
			}
	}
	
	/**
	 * Bắt lỗi Class không tồn tại
	 */
	@SuppressWarnings({ "unused", "rawtypes" })
	public void testClassNotFoundException() {
		try {
			Class test = Class.forName("Phan5.Cau7");
			System.out.println("Có tồn tại: " + test);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		
	}
	
	

	public static void main(String[] args) {
		DemoCheckedException demo = new DemoCheckedException();

//		demo.testFileNotFoundException();
		demo.testClassNotFoundException();
	}

}
