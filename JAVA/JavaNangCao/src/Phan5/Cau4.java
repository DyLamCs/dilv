package Phan5;

public class Cau4 {

	/**
	 * Xử lý Multiple Exception (Mảng (Array) ngoài giới hạn) trong Java
	 */
	public static void multipleException() {
		int arr[] = { 2, 30, 5 };

		try {
			System.out.println(arr[5]);
			int result = 50 / 50;
			System.out.println("Result = " + result);
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
