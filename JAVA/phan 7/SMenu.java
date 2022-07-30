import java.util.Scanner;

public class SMenu {

	public static void main(String[] args) {
		SMenu m = new SMenu();
		
		for(;;) {
			m.showMenu();
			m.choice();
		}
		

	}
	
	public void choice() {
		int stt, sl;
		int choiceNumber;
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.println("An 1 phim bat ky de bat dau chuong trinh");
			String test = scanner.nextLine();
			do {
				System.out.println("An 1 de bat dau || An 2 de ket thuc");
				choiceNumber = scanner.nextInt();
				
			}while((choiceNumber < 1) || (choiceNumber > 2));
			switch(choiceNumber) {
			case 1:
				System.out.println("Moi ban chon mon");
				break;
			case 2:
				System.out.println("Thank for your choice, bye bye!");
				System.exit(0);
				break;
			}
			System.out.println(">>------ODER-----<<");
			System.out.println("Ban chon mon:");
			stt = scanner.nextInt();
			System.out.println("So luong:");
			sl = scanner.nextInt();
			System.out.println(">>------BILL-----<<");
		}while((stt < 0) || (stt>8) );
		
		switch(stt) {
		case 0:
			System.out.println("CAFE gia 10.000");
			System.out.println("So luong:" + sl);
			System.out.println("Thanh Tien:" + 10000*sl);
			break;
		
		case 1:
			System.out.println("ESPRESSO gia 10.000");
			System.out.println("So luong:" + sl);
			System.out.println("Thanh Tien:" + 10000*sl);
			break;
		case 2:
			System.out.println("RISTRETTOP gia 10.000");
			System.out.println("So luong:" + sl);
			System.out.println("Thanh Tien:" + 10000*sl);
			break;
		case 3:
			System.out.println("MOCHA gia 10.000");
			System.out.println("So luong:" + sl);
			System.out.println("Thanh Tien:" + 10000*sl);
			break;
		case 4:
			System.out.println("LATTE gia 10.000");
			System.out.println("So luong:" + sl);
			System.out.println("Thanh Tien:" + 10000*sl);
			break;
		case 5:
			System.out.println("VIENNA gia 10.000");
			System.out.println("So luong:" + sl);
			System.out.println("Thanh Tien:" + 10000*sl);
			break;
		case 6:
			System.out.println("CAPPUCCINO gia 10.000");
			System.out.println("So luong:" + sl);
			System.out.println("Thanh Tien:" + 10000*sl);
			break;
		case 7:
			System.out.println("MACCHIATO gia 10.000");
			System.out.println("So luong:" + sl);
			System.out.println("Thanh Tien:" + 10000*sl);
			break;
		case 8:
			System.out.println("PANNA gia 10.000");
			System.out.println("So luong:" + sl);
			System.out.println("Thanh Tien:" + 10000*sl);
			break;
		default:
			System.out.println("Thuc uong cha co tren MENU!");
			break;

	}
}
	
	public void showMenu() {
		System.out.println(">>-----MENU DONG GIA 10K-----<<");
		System.out.println("----------------------");
		System.out.println("0: CAFE DEN    :10.000");
		System.out.println("1: ESPRESSO    :10.000");
		System.out.println("2: RISTRETTOP  :10.000");
		System.out.println("3: MOCHA       :10.000");
		System.out.println("4: LATTE       :10.000");
		System.out.println("5: VIENNA      :10.000");
		System.out.println("6: CAPPUCCINO  :10.000");
		System.out.println("7: MACCHIATO   :10.000");
		System.out.println("8: PANNA       :10.000");
		System.out.println("----------------------");
	}
	


}
