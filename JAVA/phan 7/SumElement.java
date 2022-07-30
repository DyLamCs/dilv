import java.util.Scanner;

public class SumElement {
	
	public static void main(String[] args) {
		int s;
		int i=0;
		int sum = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap so nguyen lon hown 1.");
		s = scanner.nextInt();
		
		while (sum <= s){
			sum = sum + i;
			i++;
		}
		
		System.out.println(sum);
		
		
	}

}
