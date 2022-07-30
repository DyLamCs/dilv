import java.util.Scanner;
public class Sum {
	
	public static void main(String[] args) {
		int a;
		int b;
		
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("Nhap a: ");
		a = scanner.nextInt();
		
		System.out.println("Nhap b: ");
		b = scanner.nextInt();
		
		System.out.println("a + b =" + (a+b) );
		System.out.println("a - b =" + (a-b) );
		System.out.println("a * b =" + (a*b));
		System.out.println("a / b =" + (a/b) );
		System.out.println("a % b =" + (a%b) );	
	}

}
