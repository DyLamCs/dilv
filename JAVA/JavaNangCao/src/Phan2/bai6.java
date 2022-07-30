package Phan2;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Bai6 {
	Scanner scanner = new Scanner(System.in);
	
	/**Nhap vào một chuỗi
	 * @return: str
	 */
	public String inPutString() {
		System.out.println("Nhap chuoi: ");
		String str = scanner.nextLine();
		return str;
	}
	
	/** Kiem tra nhp vao float
	 * @param sc
	 * @return num
	 */
	public float floatCheck(Scanner sc) {		
		System.out.print("Nhap so: ");
		float num=0;	
		
		try {
			num=sc.nextFloat();
			sc.nextLine();
		}
		catch(InputMismatchException e){
			System.out.print("Sai, Vui long nhap lai!\n ");
			sc.nextLine();
			num=floatCheck(sc);
		}
		return num;
		
	}
	
	/** kiem tra kieu nhap int
	 * @param sc
	 * @return
	 */
	public float intCheck(Scanner sc) {		
		System.out.println("Nhap so: ");
		float num=0;	
		
		try {
			num=sc.nextInt();
			sc.nextLine();
		}
		catch(InputMismatchException e){
			System.out.print("Sai, Vui long nhap lai!\n ");
			sc.nextLine();
			num=intCheck(sc);
		}
		return num;
		
	}
	
	/**
	 * Doi String thanh Date
	 */
	public void convertStringToDate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		Date date = sdf.parse(inPutString());	
		System.out.println(date);	
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("DDMMYYYY");
		System.out.println(sdf1.format(date));
	}
	
	/**
	 * Viết chương trình format một số nguyên thành dạng “###,###.##”
	 */
	public void formatNumber() {
	
		DecimalFormat dcf = new DecimalFormat("###,###.##");
		System.out.print("\n"+dcf.format(intCheck(scanner))+"\n");			
	}
	
	/**
	 * định dạng time trong định dạng AM-PM trong Java
	 */
	public void formatHours() {
//		Date date = new Date(2020, 05, 20, 18, 30, 20);
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
		System.out.print(sdf.format(date));
		
	}
	
	/**
	 * Cách thêm time (ngày, năm, giây) tới Date trong Java
	 */
	public void addTime() {
		Date day = new Date();
		Calendar calendar = Calendar.getInstance(); //được dùng để lấy calendar sử dụng time zone và locale mặc định.
//		lay ra thoi gian o thoi diem hien tai
		calendar.setTime(day);  //được sử dụng để thiết lập time của Calendar với Date đã cho
		System.out.println("Ngay hom nay la:     " + day);
// 		Them vao mot thang	
		calendar.add(Calendar.MONTH, 1);
		System.out.println("Cong them mot thang: " + calendar.getTime().toString());
//		Them vao mot nam
		calendar.add(Calendar.YEAR, 1);
		System.out.println("Cong vao mot nam:    " + calendar.getTime().toString());
//		Them giay vao date
		calendar.add(Calendar.SECOND, 10);
		System.out.println("Them vao 60s:        " + calendar.getTime().toString());			
	}
	
	/**
	 * Viết chương trình hiển thị phần trăm (%) của một số. Ví dụ: 25/100 ~ 25%.
	 */
	public void numberPercent() {
		double num1 = 0;
		double num2 = 0;
		
		
		System.out.print("Nhập so dat duoc:");
		num1 = scanner.nextDouble();
		
		System.out.print("Nhập tong:");
		num2 = scanner.nextDouble();
		
		NumberFormat numberFormat = NumberFormat.getPercentInstance(); // tra ve dinh dang phan tram
		String percentage = numberFormat.format(num1/num2);
		System.out.println(percentage);
		
		
	}
	
	/**
	 * Viết chương trình làm trong số với DecimalFormat.
	 */
	public void numberFormat() {
		DecimalFormat df = new DecimalFormat("#.##"); // khai bao mot DecimalFormat dang "#.##"
		df.setRoundingMode(RoundingMode.CEILING);
		System.out.print(df.format(floatCheck(scanner)));
	}
	
	
	public static void main(String[] args) throws ParseException {
		Bai6 run = new Bai6();
//		run.convertStringToDate();
//		run.formatNumber();
//		run.formatHours();
//		run.addTime();
//		run.numberPercent();
		run.numberFormat();
		
	}
}
