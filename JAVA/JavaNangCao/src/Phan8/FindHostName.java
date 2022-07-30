package Phan8;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Câu 4: Tìm hostname từ địa chỉ IP
 *
 */
public class FindHostName {

	public static void main(String[] args) {	
		InetAddress addr;	
		
		try (Scanner sc = new Scanner(System.in)){
			System.out.print("Nhập địa chỉ IP: ");
			String ip = sc.nextLine();
			
			addr = InetAddress.getByName(ip);
			System.out.println("Host name is: "+addr.getHostName());
		    System.out.println("Ip address is: "+ addr.getHostAddress());
		    
		} catch (UnknownHostException e) {
			System.out.println("Địa chỉ IP không xác định.");
		}
		
	}

	
}
