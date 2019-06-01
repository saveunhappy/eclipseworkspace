package day_19;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class Demo7 {
	public static void main(String[] args) throws Exception {
		
		File f = new File("file/stream.txt");
		
		Reader r = new FileReader(f);
		
		char[] ch = new char[1024];
		int len = -1;
		
		while((len = r.read(ch)) != -1) {
			System.out.println(new String(ch,0,len));
		}
		r.close();
	}
}	
