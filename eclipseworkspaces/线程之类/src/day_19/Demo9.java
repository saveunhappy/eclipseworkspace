package day_19;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class Demo9 {
	public static void main(String[] args) throws Exception, Exception {
		File f1 = new File("file/stream.txt");
		File f2 = new File("file/hello.txt");
		Reader reader = new InputStreamReader(new FileInputStream(f1),"GBK");
		Writer writer = new OutputStreamWriter(new FileOutputStream(f2),"GBK");
		
		char[] ch = new char[1024];
		int len  = -1;
		while((len = reader.read(ch)) != -1) {
			writer.write(ch,0,len);
		}
		reader.close();
		writer.close();
	}
}
