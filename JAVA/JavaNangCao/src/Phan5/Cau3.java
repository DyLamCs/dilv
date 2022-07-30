package Phan5;

public class Cau3 {

	/**
	 * Xử lý Multiple Exception (lỗi chia cho số 0) trong Java
	 */
	public static void multipleException() {
		int arr[] = { 2, 30, 5 };

		try {
			
			int result = 50 / 0;
			System.out.println("Result = " + result);
			
			System.out.println(arr[1]);

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Mang vuot gioi han");
		} catch (ArithmeticException e) {
			System.out.println("Khong chia duoc so so 0");
		}

	}

	public static void main(String[] args) {
		multipleException();
	}

}
