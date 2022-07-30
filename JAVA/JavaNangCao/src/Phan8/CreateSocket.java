package Phan8;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Câu 7: Cách tạo một Socket tại một port cụ thể trong Java?
 */

public class CreateSocket {
	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)) {
			
			Socket socket = new Socket("127.0.0.1", 32000);
			
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			
			while (true) {
				System.out.print("Nhap: ");
				String str = scanner.nextLine();
				if (str.equalsIgnoreCase("exit")) {
					System.out.println(socket.getLocalSocketAddress() + " Đã ngắt kết nối.");
					out.close();
					socket.close();
					break;
				}else {
					out.println(str);
					out.flush();
				}	
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.out.println("Máy chủ không xác định");
		} catch (IOException e) {
			System.out.println("Lỗi kết nối");
		}
	}
	
		
	
}
