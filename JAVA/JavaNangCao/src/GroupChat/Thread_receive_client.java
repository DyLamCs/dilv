package GroupChat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Thread_receive_client extends Thread {
	private Socket socket;
	
	public Thread_receive_client(Socket socket) {
		
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			DataInputStream in = new DataInputStream(socket.getInputStream());
			
			while (socket.isConnected()) {
				if(in.available()>0) {
					String str = in.readUTF();
					System.out.println("doc tin nhan: "+str);
				}
				else {
					sleep(500);
				}
			}
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}

