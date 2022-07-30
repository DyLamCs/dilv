package Phan8;

import java.net.InetAddress;
import java.net.UnknownHostException;

/** 
 * Câu 5 Lấy địa chỉ IP và hostname của máy
 *
 */
public class GetLocalAddress {
	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println("Local HostAddress: " + address.getHostAddress());
			String hostname = address.getHostName();
			System.out.println("Local host name: " + hostname);
		} catch (UnknownHostException e) {
			System.out.println("Không lấy được địa chỉ IP và hostname của máy!");
		}
	}
}
