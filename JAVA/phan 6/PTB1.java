import java.util.Scanner;

public class PTB1 {
	int a,b;
	public static void main(String[] args) {
		PTB1 m = new PTB1();
		m.nhap();
		m.giaiPhuongTrinh();

	}
	
	public void nhap() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Nhap a = ");
		a = scanner.nextInt();
		
		System.out.print("Nhap b = ");
		b = scanner.nextInt();
	}
	
	public void giaiPhuongTrinh() {
		if (a==0 && b==0) {
			System.out.println("Phuong trinh vo so nghiem.");
		} else if(a==0 && b!=0) {
			System.out.println("Phuong trinh vo nghiem.");
		}else
			System.out.println("Phuong trinh co nghiem duy nhat X = " + ((float)-b / (float)a));
			
		
	}

}
