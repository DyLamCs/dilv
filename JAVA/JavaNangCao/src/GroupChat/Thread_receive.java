package GroupChat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Thread_receive extends Thread {
	private Socket socket2;
	
	public Thread_receive(Socket socket2) {		
		this.socket2 = socket2;
	}
	
	@Override
	public void run() {		

		DataInputStream in=null;
		try {
			in = new DataInputStream(socket2.getInputStream());
		} catch (IOException e1) {
			e1.printStackTrace();
		};
		@SuppressWarnings("unused")
		String tingui;
		
		if(in!=null) {
			while (socket2.isConnected()) {			
				try {					
					if (in.available()>0) {
						String doctin=in.readUTF();
						System.out.println(socket2.getLocalSocketAddress() + "da gui den cho server");
						Server1.guiTin(doctin, socket2);
					}			
					else {
						sleep(500);
					}
				} catch (IOException | InterruptedException e) {
					e.printStackTrace();
				}				
			}		
		}
		
	}
}
