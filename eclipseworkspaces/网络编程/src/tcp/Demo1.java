package tcp;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo1 {
	public static void main(String[] args) throws Exception {
		String data = "hello";
		
		ServerSocket server = new ServerSocket(8888);
		System.out.println("服务端已经就绪");
		boolean accept = true;
		while(accept) {
			Socket client = server.accept();
			PrintStream out = new PrintStream(client.getOutputStream());
			out.println(data);
			out.close();
		}
		server.close();
	}
}
