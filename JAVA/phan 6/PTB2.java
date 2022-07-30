import java.util.Scanner;

public class PTB2 {
	int a,b,c;
	public static void main(String[] args) {
		PTB2 m = new PTB2();
		m.nhap();
		m.ketqua();

	}
	
	public void nhap() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Nhap a = ");
		a = scanner.nextInt();
		
		System.out.print("Nhap b = ");
		b = scanner.nextInt();
		
		System.out.print("Nhap c = ");
		c = scanner.nextInt();
	}
	
	public void ketqua() {
		float dt;
		
		dt = (b*b) - (4*a*c);
		
		if (dt < 0) {
			System.out.println("Phuong trinh vo nghiem");
		}else if (dt==0) {
			System.out.println("Phuong trinh co nghiem kep X1 = X2 = " + (-(float)b)/2*(float)a);
		}else {
			System.out.println("Phuong trinh 2 nghiem");
			System.out.println("X1 = " + ( ((float)-b + Math.sqrt(dt)) / 2*(float)a) );
			System.out.println("X2 = " + ( ((float)-b - Math.sqrt(dt)) / 2*(float)a) );
		}
			
	}

}
