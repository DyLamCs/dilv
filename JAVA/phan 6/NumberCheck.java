import java.util.Scanner;

public class NumberCheck {
	int num;
	
	public static void main(String[] args) {
		NumberCheck m = new NumberCheck();
		m.input();
		m.isPositive();
		m.isOdd();

	}
	public void input() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Nhap num = ");
		num = scanner.nextInt();	
	}
	
	public void isPositive() {
		if (num > 0) {
			System.out.println(num + " la so duong");
		}else if(num < 0) {
			System.out.println(num + " la so am");
		}
		else
			System.out.println(num + " la so 0");		
	}
	
	public void isOdd(){
		if(num%2==0) {
			System.out.println(num + " a so chan");
		}else
			System.out.println(num + " la so le");
	}
}
