package TCPSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient extends Thread {
	Socket socket = null;
	static int i = 0;

	public TCPClient(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			if (i == 0) {
				i++;
				Scanner scanner = new Scanner(System.in);
				PrintWriter out = new PrintWriter(socket.getOutputStream());
				while (true) {
					System.out.print("Enter a line: ");
					String str = scanner.nextLine();
					if (str.equalsIgnoreCase("exit")) {
						System.out.println(socket.getLocalSocketAddress() + " đã ngắt kết nối với máy chủ");
						out.println(str);
						out.flush();
						out.close();
						scanner.close();
						socket.close();
						break;
						
					} else {
						System.out.println("Sent: ");

						out.println(str);
						out.flush();

					}

				}
				
			} else if (i==1) {
				i=0;
				sleep(500);
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				while (socket.isConnected()) {
					String line = reader.readLine();
					
					System.out.println("Received: " + line);
				}
				reader.close();
			}
		} catch (IOException e) {
			System.out.println("Dong ket noi");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		try {
			Socket socket = new Socket("127.0.0.1", 32000);	
//			Socket socket = new Socket("10.32.62.94", 6789);	
			new TCPClient(socket).start();
		} catch (Exception e) {
			System.out.println("Loi ket noi!");
		}
	}
}
