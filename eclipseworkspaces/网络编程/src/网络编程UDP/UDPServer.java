package 网络编程UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {
	public static void main(String[] args) {
		DatagramSocket ds = null;
		try {
			//创建UDP服务器端的对象，必须制定端口8000以前的都被占用了，建议是10000以后 的
			ds = new DatagramSocket(10005);
			//定义接收数据的字节数组
			byte[] bs = new byte[1024];
			//定义接收的数据包
			DatagramPacket dp = new DatagramPacket(bs,bs.length);
			System.out.println("服务器已经启动");
			ds.receive(dp);
			//获得发送端的IP
			InetAddress ia = dp.getAddress();
			//获取数据包中的数据
			byte[] bs1 = dp.getData(); 
			//获得接收数据的长度(实际接收的长度)
			int len = dp.getLength();
			//组装接收的数据
			String data = new String(bs1,0,len);
			System.out.println(ia.getHostAddress()+"接收了"+data);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ds!=null) {
				ds.close();
			}
		}
		
		
	}
}
