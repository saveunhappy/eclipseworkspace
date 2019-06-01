package 网络编程TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {
	public static void main(String[] args) {
		ServerSocket ss = null;
		BufferedReader br = null;
		Socket s  =null;
		try {
			//创建服务端的服务套接字
			ss = new ServerSocket(10001);
			//接收到了一个连接的请求，等待有客户端来建立连接
			s = ss.accept();
			//获得这个通道的输入输出流对象
			OutputStream out = s.getOutputStream();
			InputStream in = s.getInputStream();
			br = new BufferedReader(new InputStreamReader(in));
			
			InetAddress ia = s.getInetAddress();
			String line = null;
			while((line = br.readLine())!=null) {
				
			System.out.println(ia.getHostAddress()+"发送了："+line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(br!= null) {
						
						br.close();
					}
					if(s!=null) {
						s.close();
					}
					if(ss!=null) {
						ss.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}
}
