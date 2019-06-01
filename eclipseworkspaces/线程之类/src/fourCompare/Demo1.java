package fourCompare;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Demo1 {
	public static void main(String[] args) throws Exception {
		File f1 = new File("file/stream.txt");
		File f2 = new File("file/hh.txt");
		//test1(f1,f2);
		//test2(f1,f2);
		//test3(f1,f2);
		test4(f1,f2);
	}

	private static void test1(File f1, File f2) throws Exception {
		InputStream in = new FileInputStream(f1);
		OutputStream out = new FileOutputStream(f2);
		int len = -1;
		while((len = in.read()) != -1) {
			out.write(len);
		}
		out.close();
		in.close();
	}
	private static void test2(File f1, File f2) throws Exception {
		InputStream in = new BufferedInputStream(new FileInputStream(f1));
		OutputStream out = new BufferedOutputStream(new FileOutputStream(f2));
		int len = -1;
		while((len = in.read()) != -1) {
			out.write(len);
		}
		out.close();
		in.close();
	}
	private static void test3(File f1, File f2) throws Exception {
		InputStream in = new FileInputStream(f1);
		OutputStream out = new FileOutputStream(f2);
		byte[] buffer = new byte[1024];
		int len = -1;
		while((len = in.read(buffer)) != -1) {
			out.write(buffer,0,len);
		}
		out.close();
		in.close();
	}
	private static void test4(File f1, File f2) throws Exception {
		InputStream in = new BufferedInputStream(new FileInputStream(f1));
		OutputStream out = new BufferedOutputStream(new FileOutputStream(f2));
		byte[] buffer = new byte[1024];
		int len = -1;
		while((len = in.read(buffer)) != -1) {
			out.write(buffer,0,len);
		}
		out.close();
		in.close();
	}
}	
