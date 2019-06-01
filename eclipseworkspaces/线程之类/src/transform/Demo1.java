package transform;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class Demo1 {
	public static void main(String[] args) throws Exception {
		File f1 = new File("file/hh.txt");
		File f2 = new File("file/hhh.txt");
		Reader r = new InputStreamReader(new FileInputStream(f1),"GBK");
		Writer w  =new OutputStreamWriter(new FileOutputStream(f2),"GBK");
		//字节流转换为字符流
		int len = -1;
		char[] ch = new char[1024];
		while((len = r.read(ch)) != -1) {
			w.write(ch,0,len);
		}
		r.close();
		w.close();
	}
}
