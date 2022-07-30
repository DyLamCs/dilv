package TCPSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer extends Thread{
	Socket socket = null;
	
	public TCPServer(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		
		while (socket.isConnected()) {
			String line = reader.readLine();
				if ("exit".equalsIgnoreCase(line)) break;
				out.print(line);
				out.flush();	
				
		}
		reader.close();
		out.close();
		socket.close();
		} catch (IOException e) {
//			e.printStackTrace();
			System.out.println(socket.getLocalSocketAddress() + " đã đóng kết nối đột ngột.");
		}
	}

	public static void main(String[] args) {
		try (ServerSocket serverSocket = new ServerSocket(6789)) {
			System.out.println("Listening...");
			while (true) {
				Socket socket = serverSocket.accept();
				new TCPServer(socket).start();
			}
		} catch (IOException e) {
			System.out.println("Loi ket noi");
		}
		
	}
}
