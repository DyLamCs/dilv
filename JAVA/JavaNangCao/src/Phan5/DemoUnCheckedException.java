package Phan5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DemoUnCheckedException extends Thread {
	/**
	 * Bắt lỗi chia cho 0
	 */
	public void testArithmeticException() {
		try {
			@SuppressWarnings("unused")
			int Result = 50 / 0;
		} catch (ArithmeticException e) {
			System.out.println(e);
			System.err.println("Lỗi chia 0");
		}

	}

	/**
	 * Bắt lỗi lấy giá trị vượt ngoài phạm vi của mãng
	 */
	public void testArrayIndexOutOfBoundsException() {
		int[] arr = { 1, 2, 3 };
		try {
			System.out.println(arr[4]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}

	}

	/**
	 * Bắt lỗi nhập sai kiểu dữ liệu
	 */
	public void testInputMismatchException() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Nhap Int: ");
			@SuppressWarnings("unused") //để thông báo trình biên dịch không cảnh báo việc sử dụng phương thức có sử dụng
			int temp = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println(e);
		}

	}

	/**
	 * Bắt lỗi ép kiểu không hợp lệ
	 */
	public void testClassCastException() {
		Object i = Integer.valueOf(48);
		try {
			@SuppressWarnings("unused") //để thông báo trình biên dịch không cảnh báo việc sử dụng phương thức có sử dụng
			String str = (String) i;
		} catch (ClassCastException e) {
			System.out.println(e);
		}

	}

	/**
	 * Bắt lỗi tạo mảng với cỡ của mảng là số ấm
	 */
	public void testNegativeArraySizeException() {
		try {
			int[] arr = new int[-5];
			System.out.println("Arr lenght : " + arr.length);
		} catch (NegativeArraySizeException e) {
			System.out.println(e + " Lỗi tạo mãng âm");
		}
	}
	
	
		@Override
			public void run() {
				try {
					System.out.println("test xem luồng có chạy không?");
					Thread.sleep(2000);
					/*
					 * Nếu thread nằm trong trạng thái sleep hoặc wait (nghĩa là sleep() hoặc wait() được gọi ra),
					 * việc gọi phương thức interrupt() trên thread
					 * sẽ phá vỡ trạng thái sleep hoặc wait và ném ra ngoại lệ InterruptedException.*/
					
				} catch (InterruptedException e) {   // xử lý gián đoạn ngoại lệ
					System.out.println(e);
				}
			}


	public static void main(String[] args) {
		DemoUnCheckedException demo = new DemoUnCheckedException();

		Thread t1 = new Thread(demo);

//		demo.testArithmeticException(); 			// Bắt lỗi chia cho 0
//		demo.testArrayIndexOutOfBoundsException(); 	// Bắt lỗi lấy giá trị vượt ngoài phạm vi của mãng
//		demo.testInputMismatchException(); 			// Bắt lỗi nhập sai kiểu dữ liệu
//		demo.testClassCastException(); 				// Bắt lỗi ép kiểu không hợp lệ
//		demo.testNegativeArraySizeException(); 		// Bắt lỗi tạo mảng với cỡ của mảng là số ấm
		
		t1.start();               //xử lý gián đoạn ngoại lệ
		t1.interrupt();
	}

}
