package copyDemo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CopyDemo {
	public static void main(String[] args) {
		copy();
		System.out.println("done");
	}
	public static void copy() {
		Reader reader = null;
		
		Writer writer = null;
		
		try {
			//创建文件读取对象
			reader = new FileReader("src/reader/Demo1.java");
			//创建文件写入对象
			writer = new FileWriter("Copy.java");
			int num = -1;
			
			while((num=reader.read()) != -1)
			{
				writer.write(num);
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(writer != null)
				{
					writer.close();
					if(reader != null) {
						reader.close();
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
