package day_19;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Demo3 {
	public static void main(String[] args) throws Exception {
		File target = new File("file/stream.txt");
		OutputStream out = new FileOutputStream(target,true);
		out.write("abcde".getBytes());
		out.close();
	}
}
