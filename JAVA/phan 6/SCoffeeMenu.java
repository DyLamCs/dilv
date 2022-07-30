import java.util.Scanner;

public class SCoffeeMenu {
	int id[];
	String drinks[];
	int price[];
	int n = 2;
	public static void main(String[] args) {
		SCoffeeMenu m = new SCoffeeMenu();
		m.showMenu();
		m.oder();

	}
	
	public void showMenu() {
		id = new int[n];
		drinks = new String[n];
		price = new int[n];
		
		id[0] = 0;
		id[1] = 1;
		drinks[0] = "CAFE";
		drinks[1] = "MILK";
		price[0] = 10;
		price[1] = 15;
		System.out.println(">>------MENU-----<<");
		System.out.println(id[0] + " " +  drinks[0] + " " + price[0] );
		System.out.println(id[1] + " " +  drinks[1] + " " + price[1] );
		
	}
	public void oder() {
		int stt,sl;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println(">>------ODER-----<<");
		System.out.print("Nhap id mon can mua:");
		stt = scanner.nextInt();
		System.out.print("Nhap sl can mua:");
		sl = scanner.nextInt();
		System.out.println(">>------BILL-----<<");
		switch(stt) {
		case 0:
			System.out.println("CAFE - 10.000" + "  -  " + "So Luong:" + sl + "  -  " + " Thanh tien:"+sl*10 + "k");
			break;
		
		case 1:
			System.out.println("MILK - 15.000" + "  -  " + "So Luong:" + sl + "  -  " + " Thanh tien:"+sl*15 + "k");
			break;
		default:
			System.out.println("Thuc uong cha co tren MENU!");
		}
		
	}

}
