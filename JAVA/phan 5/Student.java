import java.util.Scanner;

public class Student {

	public static void main(String[] args) {
		String fullName;
		int yob;
		String address;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Name: ");
		fullName = scanner.nextLine();
		
		System.out.print("Day of birth: ");
		yob = scanner.nextInt();
		
		scanner.nextLine();
		
		System.out.print("Address: ");
		address = scanner.nextLine();
		
		System.out.println("Thong tin vua nhap:");
		System.out.println("-Name: " + fullName);
		System.out.println("-Day of birth: " + yob);
		System.out.println("-Address: " + address);
		
		
	}

}
