import java.util.ArrayList;
import java.util.Scanner;

public class CoffeeMenu {
	
	public static void main(String[] args) {
		CoffeeMenu m = new CoffeeMenu();
		m.addMenu();
		m.showMenu();
		m.oder();

	}
	
	ArrayList<DoUong> menu = new ArrayList<DoUong>();
	public void addMenu() {
		System.out.println(">>---------------------MENU------------------------<<");
		menu.add(new DoUong(1, "CAFE", 10));
		menu.add(new DoUong(2, "TEA1", 12));
		menu.add(new DoUong(3, "MILK", 15));
		menu.add(new DoUong(4, "COCA", 11));
		
	}
	
	public void showMenu() {
		for (DoUong doUong : menu) {
			System.out.println(doUong.getId() + " - " + doUong.getName() + " - " + doUong.getPrice());
		}
	}
	
	public void oder() {
		int stt, sl;
		Scanner scanner =new Scanner(System.in);
		System.out.println(">>---------------------ORDER-----------------------<<");
		System.out.print("Nhap ID muon oder:");
		stt = scanner.nextInt();
		
		System.out.print("Nhap SL muon oder:");
		sl = scanner.nextInt();
		System.out.println(">>---------------------BILL------------------------<<");
		System.out.println(sl + " " + menu.get(stt-1).getName() + " Gia " + menu.get(stt-1).getPrice()*sl + "k");
	}
	
	
}

