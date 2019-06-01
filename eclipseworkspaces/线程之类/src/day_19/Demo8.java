package day_19;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Demo8 {
	public static void main(String[] args) throws Exception {
		//×Ö·û»º³åÊäÈëÁ÷
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("file/stream.txt",true));
		bos.write("hello world".getBytes());
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("file/stream.txt"));
		byte[] bs = new byte[1024];
		int len = -1;
		while((len = bis.read(bs)) != -1) {
			System.out.println(new String(bs,0,len));
		}
		bis.close();
		bos.close();
		
		
		
	}
}
