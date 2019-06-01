package tcp;

import java.net.Socket;
import java.util.Scanner;

public class Demo2 {
	public static void main(String[] args) throws Exception{
		Socket client = new Socket("localhost",8888);
		Scanner input = new Scanner(client.getInputStream());
		while(input.hasNextLine()) {
			String line = input.nextLine();
			System.out.println(line);
		}
		input.close();
		client.close();
	}
}
