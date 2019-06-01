package 字符编码输出;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class Demo1 {
	public static void main(String[] args) {
		/**
		PrintWriter pw = null;
		try {
			 pw = new PrintWriter("1.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pw != null) {
				pw.close();
				//这里不用try/catch因为在源代码中他自己捕获了自己的异常
			}
		}
		*/
		
		
		
		
		/**
		 * 写入的编码和读取的编码必须要一致，否则会乱码
		 */
		printCharset();
		ReadCharset();
	}
	public static void printCharset() {
		OutputStreamWriter ow = null;
		try {
			 ow = new OutputStreamWriter(new FileOutputStream("2.txt"),"GBK");
			 ow.write("中国");
			 
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ow != null) {
				try {
					ow.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
				
	}
	public static void ReadCharset() {
		InputStreamReader ow = null;
		try {
			 ow = new InputStreamReader(new FileInputStream("2.txt"),"GBK");
			 char[] chs = new char[1024];
			 int len = ow.read(chs);
			 System.out.println(new String(chs,0,len));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ow != null) {
				try {
					ow.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
				
	}
}
