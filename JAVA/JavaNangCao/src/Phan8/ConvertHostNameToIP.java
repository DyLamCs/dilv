package Phan8;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Câu 1: Đổi hostname thành địa chỉ IP
 *
 */
public class ConvertHostNameToIP {
	public static void main(String[] args) {

		InetAddress address = null;

		try (Scanner sc = new Scanner(System.in)) {

			System.out.print("Nhập host name: ");
			String ip = sc.nextLine();

			address = InetAddress.getByName(ip);
			System.out.println(address.getHostName() + " = " + address.getHostAddress());
		} catch (UnknownHostException e) {
			System.out.println("Máy chủ không xác định");
		}

	}
	 
	
	
}
