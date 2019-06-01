package 网络编程UDP3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClient implements Runnable{
		private String ip;
		private int port;
	
	
	public UDPClient(String ip, int port) {
			super();
			this.ip = ip;
			this.port = port;
		}


	@Override
	public void run() {
		DatagramSocket ds = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			// 创建客户端的套接字对象
			ds = new DatagramSocket();
			// 定义一个发送的内容
//			字符串.getBytes()将字符串转换为字节数组
			while(true) {
				
			String line = br.readLine();
			byte[] bs = line.getBytes();
			// 创建要发送的目的的IP地址也可以是本机的名字也可以是192.168.1.102(本人电脑)
			InetAddress is = InetAddress.getByName(ip);
			// 打数据包
			DatagramPacket dp = new DatagramPacket(bs, bs.length, is, port);
			// 发送数据
			ds.send(dp);
			
			if("exit".equals(line)) {
				break;
			}
			
			} 
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ds != null) {
				ds.close();
			}
		}
		
	}


	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}


	public int getPort() {
		return port;
	}


	public void setPort(int port) {
		this.port = port;
	}


	
}
