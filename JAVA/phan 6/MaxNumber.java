import java.util.Scanner;

public class MaxNumber {

	public static void main(String[] args) {
		float a;
		float b;	
		Scanner scanner = new Scanner(System.in);
		//nhap a
		System.out.print("Nhap a = ");
		a = scanner.nextFloat();	

		//nhap b
		System.out.print("Nhap b = ");
		b = scanner.nextFloat();
		
		if(a>b) {
			System.out.println(" a > b");
		} else if(a<b) {
			System.out.println(" a < b");
		}else
			System.out.println(" a = b");
	}

}
