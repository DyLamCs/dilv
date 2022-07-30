import java.util.Scanner;

public class ReadChar {

	public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Nhap n: ");
		n = scanner.nextInt();
		
		System.out.println("Ban da nhap so: " + n);
		System.out.println("Kieu da ep: " + (char)n);
		
	}

}
