package day_19;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Demo4 {
	public static void main(String[] args) throws Exception {
		
		File f = new File("file/stream.txt");
		InputStream in = new FileInputStream(f);
		byte[] buffer = new byte[1024];
		int len  =-1;
		while((len = in.read(buffer)) != -1) {
			System.out.println(new String(buffer,0,len));
		}
		in.close();
	}
}
