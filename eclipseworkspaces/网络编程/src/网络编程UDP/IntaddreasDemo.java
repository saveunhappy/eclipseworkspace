package 网络编程UDP;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IntaddreasDemo {
	public static void main(String[] args) {
		
		
		try {
			InetAddress is = InetAddress.getLocalHost();
			System.out.println(is);
			//本地的ID字符串
			String ip = is.getHostAddress();
			System.out.println(ip);
			//获得主机名
			
			String name = is.getHostName();
			System.out.println(name);
			
			InetAddress i1 = InetAddress.getByName("MSI");
			System.out.println(i1);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
