package Phan9;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ConvertType {
	Scanner scanner = new Scanner(System.in);

	/**
	 * Đổi kiểu String -> Int
	 * 
	 * @return 0 nếu xảy ra Exception
	 */

	public int stringToIntExample() {
		int i;
		System.out.println("Nhập chuỗi số: ");

		String str = scanner.nextLine();
		try {
			i = Integer.parseInt(str);
		} catch (Exception e) {
			return 0;
		}
		return i;
	}

	/**
	 * Đổi kiểu String -> Long
	 * 
	 * @return 0 nếu xảy ra Exception
	 */
	public long stringToLongExample() {
		long l;
		System.out.println("Nhập chuỗi số: ");

		String str = scanner.nextLine();
		try {
			l = Long.parseLong(str);

		} catch (Exception e) {
			return 0;
		}
		return l;
	}

	/***
	 * Đổi kiểu String -> Float
	 * 
	 * @return 0 nếu xảy ra Exception
	 */
	public float stringToFloatExample() {
		Float f;
		System.out.println("Nhập chuỗi số: ");

		String str = scanner.nextLine();
		try {
			f = Float.parseFloat(str) + 10;

		} catch (Exception e) {
			return 0;
		}
		return f;
	}

	/***
	 * Đổi kiểu String -> Double
	 * 
	 * @return 0 nếu xảy ra Exception
	 */
	public double stringToDoubleExample() {
		double d;

		System.out.println("Nhập chuỗi số: ");
		String str = scanner.nextLine();
		try {
			d = Double.parseDouble(str);
			System.out.println("Gia tri cua string: " + str);
			System.out.println("Gia tri cua double: " + d);

		} catch (Exception e) {
			return 0;
		}
		return d;
	}

	/**
	 * Đổi kiểu String -> Date
	 * 
	 * @return 0 nếu xảy ra Exception
	 */
	public Date stringToDateExample() {
		SimpleDateFormat isDate = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {
			System.out.println("Nhập ngày kiểu dd/MM/yyyy: ");
			String stringDate = scanner.nextLine();
			date = isDate.parse(stringDate);
		} catch (Exception e) {
			date = new Date();
		}
		return date;
	}

	public static void main(String[] args) {
		ConvertType demo = new ConvertType();

//		System.out.println(demo.stringToDateExample());
		System.out.println(demo.stringToIntExample());

	}

}
