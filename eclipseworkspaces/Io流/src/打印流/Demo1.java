package ´òÓ¡Á÷;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Demo1 {
	public static void main(String[] args) {
		PrintWriter pw = null;
		try {
			 pw = new PrintWriter("c.txt");
			 pw.print("aaa");
			 pw.print('c');
			 pw.print(true);
			 pw.println(1);
			 pw.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pw!=null) {
				pw.close();
			}
		}
		
		
	}
}
