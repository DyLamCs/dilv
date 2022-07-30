package Phan8;

import java.io.IOException;
import java.net.ServerSocket;


/**
 * Câu 6: Cách kiểm tra có hay không một port đang được sử dụng trong Java?
 *
 * Từ 0-1023: là cổng hệ thống (common hay well-known ports), 
 * được dành riêng cho các quá trình của hệ thống. 
 * 
 * Từ 1024-49151: là cổng phải đăng ký
 * (registered port). Các ứng dụng muốn sử dụng cổng này phải đăng ký với IANA
 * (Internet Assigned Numbers Authority).
 *  
 * Từ 49152-65535: là cổng dùng riêng hay
 * cổng động (dynamic hay private port). Người sử dụng có thể dùng cho các ứng
 * dụng của mình, không cần phải đăng ký.
 */
public class CheckPort {
	public static void main(String[] args) {

		for (int i = 0; i < 137; i++) {
			try {
				/*ServerSocket trong Java được sử dụng bởi các ứng dụng Server 
				 * để thu nhận một cổng và nghe các yêu cầu từ Client.*/
				ServerSocket skt = new ServerSocket(i);
				System.out.println(i);
				skt.close();
				
			} catch (IOException e) {
				System.out.println("Cổng " + i + " được sử dụng");
			}
		}
	}
}
