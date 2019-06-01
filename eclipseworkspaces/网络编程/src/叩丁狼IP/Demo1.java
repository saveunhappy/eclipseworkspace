package ßµ¶¡ÀÇIP;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Demo1 {
	public static void main(String[] args) throws Exception {
		InetAddress ip = InetAddress.getByName("MSI");
		System.out.println(ip);
		System.out.println(ip.getHostName());
		System.out.println(ip.getHostAddress());
	}
}
