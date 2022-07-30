package Phan8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


/**
 * Câu 2: Tạo một Multithreaded Server
 *
 */
public class MultiThreadServer  {
	
	
	public static void main(String[] args) {
		ServerSocket server = null;
		
		
		try {
			
			server = new ServerSocket(32000);
			server.setReuseAddress(true);
//			/the main thread is just accepting new connections
			while (true) {
				Socket client = server.accept();
				
				ClientHanler clientHanler = new ClientHanler(client);
				new Thread(clientHanler).start();
			}
			
			
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			
			
			if (server != null) {
				try {
					server.close();
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
		}
	}
	
	
	
	private static class ClientHanler implements Runnable{
		private final Socket clientSocket;
		
		static ArrayList<Socket> arrSockets = new ArrayList<Socket>();

		public ClientHanler(Socket clientSocket) {
			this.clientSocket = clientSocket;
			arrSockets.add(clientSocket);
		}


		@Override
		public void run() {
			PrintWriter out = null;
			BufferedReader in = null;
	
			try {
				out = new PrintWriter(clientSocket.getOutputStream(),true);
				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				
				String line;
				while ((line = in.readLine()) !=null ) {
					System.out.println("Sent from the client: " + line);
					out.print(line);
	
				}
			} catch (IOException e) {
				System.out.println(e);
			} finally {
				try {
					if (out != null) {
						out.close();
					}
					if (in != null) {
						in.lines();
						clientSocket.close();
					}
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
		}
		
	}

}
