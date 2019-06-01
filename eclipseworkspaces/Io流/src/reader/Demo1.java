package reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo1 {
	public static void main(String[] args) {
	
		readFile();
		
	}
	public static void readFile() {
		FileReader fr = null;
		
		try {
			fr = new FileReader("Text.txt");
			//返回的是字符的ascll码值
//			int num  =fr.read();
//			System.out.println((char)num);
//			num  =fr.read();
//			System.out.println(num);
			//
//			while(num!=-1) {
//				num  =fr.read();
//				System.out.print((char)num);
//			}
			/**
			 * 用这种方式
			 */
			int num = 0;
			while((num = fr.read()) != -1) {
				System.out.print((char)num);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(fr!=null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-gene 	rated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
}
