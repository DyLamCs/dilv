package Phan8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * GreetingClient sau là một chương trình Client kết nối tới một Server bởi sử
 * dụng một Socket và gửi một lời chào, và sau đó đợi một phản hồi.
 */
public class GreetingClient {
	public static void main(String[] args) {
		String nameServer = "127.0.0.1";

		int port = 10;
		try {
			System.out.println("Ket noi toi " + nameServer + " on port " + port);
			Socket client = new Socket(nameServer, port);
			System.out.println("Just connected to " + client.getRemoteSocketAddress());
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
			out.writeUTF("Hello from " + client.getLocalSocketAddress());
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			System.out.println("Server says " + in.readUTF());
			client.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
