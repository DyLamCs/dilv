import java.util.Scanner;

public class StringArray {

	public static void main(String[] args) {
		int n;
		int arr[] ;
		int a;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Mang co bao nhieu phan tu: ");
		n = scanner.nextInt();
		
		arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			System.out.print("Nhập phần tử thứ " + (i) + ": ");
			arr[i] = scanner.nextInt();
		}
		
		System.out.print("Nhap so nguyen: ");
		a = scanner.nextInt();
		
		System.out.print("Gia tri phan tu " + a + " co gia tri = " + arr[a]);
	}

}