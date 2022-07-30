package GroupChat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Thread_send extends Thread{
	Scanner scanner = new Scanner(System.in);
	private Socket socket1;
	
	public Thread_send(Socket socket1) {		
		this.socket1 = socket1;
	}
		
	@Override
	public void run() {		
		OutputStream outToServer = null;
		try {
			outToServer = socket1.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		DataOutputStream out =new DataOutputStream(outToServer);		
		
		
		String tingui;
		
		while (socket1.isConnected()) {
			tingui=scanner.nextLine();
			try {
				out.writeUTF(tingui);
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		
	}

}
