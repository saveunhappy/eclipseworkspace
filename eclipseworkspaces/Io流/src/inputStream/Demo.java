package inputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Demo {
	
		public static void main(String[] args) {
			readerFile3();
			// System.out.println("done");
		}
		public static void readerFile() {
			//创建字节输入流的对象
			InputStream in  =null;
			/**
			 * 字符流能办到的，字节流也能办到，
			 * 字节流能办到的，字符流不一定能办到
			 * 字节流能读取图片，视频各种二进制的东西
			 */
			try {
	/**
	 * 单个字节读取的效率很低
	 */
			in = new FileInputStream("e.txt");
	
			
				int num = in.read();
				System.out.println(num);
				System.out.println((char)num);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(in!=null) {
					try {
						in.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		public static void readerFile1() {
			//创建字节输入流的对象
			InputStream in  =null;
			
			try {
	/**
	 * 单个字节读取的效率很低
	 */
			in = new FileInputStream("e.txt");
			
			byte[] bs = new byte[1024];
			int len = in.read(bs);
			System.out.println(new String(bs,0,len));
			
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(in!=null) {
					try {
						in.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		public static void readerFile3() {
			//创建字节输入流的对象
			InputStream in  =null;
			
			try {
	/**
	 * 单个字节读取的效率很低
	 */
			in = new FileInputStream("e.txt");
	
			byte[] bs = new byte[1024];
			//这里面穿的索引为1的话，就是往索引为1的地方放数据的，索引为0的地方为0，就是什么也没有，
			//所以用这三个参数的构造器，输入的时候是从哪开始，输出的时候也得从哪开始
			
			int len = in.read(bs, 1, 3);
			System.out.println(len);
			System.out.println(new String(bs,1,len));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(in!=null) {
					try {
						in.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
}
