package Phan5;

public class Cau5 {
	/**
	 * in Stack của Exception trong Java
	 */
	public static void temp1() {
		try {
			int result = 5 / 0;
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		temp1();
	}
}
