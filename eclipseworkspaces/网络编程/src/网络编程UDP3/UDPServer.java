package 网络编程UDP3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer implements Runnable {

		private int port;
	
		public UDPServer(int port) {
			super();
			this.port = port;
		}

		public int getPort() {
			return port;
		}

		public void setPort(int port) {
			this.port = port;
		}

		@Override
		public void run() {

			DatagramSocket ds = null;
			
			try {
				//创建UDP服务器端的对象，必须制定端口8000以前的都被占用了，建议是10000以后 的
				ds = new DatagramSocket(port);
				//定义接收数据的字节数组
				byte[] bs = new byte[1024];
				System.out.println("服务器已经启动");
				//定义接收的数据包
				
				
				while(true) {
				DatagramPacket dp = new DatagramPacket(bs,bs.length);
				ds.receive(dp);
				//获得发送端的IP
				InetAddress ia = dp.getAddress();
				//获取数据包中的数据
				byte[] bs1 = dp.getData(); 
				//获得接收数据的长度(实际接收的长度)
				int len = dp.getLength();
				//组装接收的数据
				String data = new String(bs1,0,len);
				if("exit".equals(data)) {	
					break;
				}
				System.out.println(ia.getHostAddress()+"接收了"+data);
				
				}
				
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
