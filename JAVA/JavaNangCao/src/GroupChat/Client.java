package GroupChat;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread {
	Scanner scanner = new Scanner(System.in);
	@Override
	public void run() {
		
		String string_ip;
		System.out.println("Nhap ip muon ket noi: ");
		string_ip = scanner.nextLine();
		int port = 7777;

		try {
			Socket clientSocket = new Socket(string_ip, port);
			System.out.println("tin nhan: ");
			
			Thread_send t1= new Thread_send(clientSocket);
			t1.start();
			
			Thread_receive_client t2=new Thread_receive_client(clientSocket);
			t2.start();	
			
		} catch (IOException e) {
			System.out.print("khong tim thay!");
		}
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		client.start();		
	}
}

