package GroupChat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server1 extends Thread {
	private ServerSocket serverSocket;
	static ArrayList<Socket> list = new ArrayList<Socket>();
	
	public Server1(int port) throws IOException{
		serverSocket = new ServerSocket(7777);
//		serverSocket.setSoTimeout(100000);	// thoi gian cho de server eccept yeu caau ket noi
	}
	
	/**
	 * 
	 * @param tinnhan
	 * @param sk
	 * @throws IOException
	 */
	static public void guiTin(String tinnhan, Socket sk) throws IOException {		
		for (Socket socket : list) {
			if (!socket.equals(sk)) {
				DataOutputStream out =new DataOutputStream(socket.getOutputStream());	
				out.writeUTF(tinnhan);
				out.flush();
			}
		}
	}
	
	@Override
	public void run() {
		while (true) {
			System.out.println("Listening...");
			
			Socket socket;
			try {
				socket = serverSocket.accept();
				System.out.println("da ket toi voi "+ socket.getLocalAddress());
				list.add(socket);
				
				new Thread_receive(socket).start();
				
			} catch (IOException e) {
				//e.printStackTrace();
				System.out.print("het thoi gian cho!");
			}		
		}
	}
	
	public static void main(String[] args) throws IOException {
		Server1 sv=new Server1(7777);		
		sv.start();
	}
}
