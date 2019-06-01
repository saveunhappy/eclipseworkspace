package 打印流;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Demo3 {
	public static void main(String[] args) {
		PrintWriter pw = null;
		BufferedReader bw = null;
		try {
			// pw = new PrintWriter(System.out);
			//自动刷新
			 /**
			  * PrintFile里面的参数如果是new FileWriter("")，就是往文件里面打印东西，如果是
			  * System.out就是往控制台打印东西
			  */
			 pw = new PrintWriter(new FileWriter("student.txt"),true);
			 bw = new BufferedReader(new FileReader("a.txt"));
			 String line = null;
			 while((line = bw.readLine()) != null) {
				 pw.println(line);
//				 自动刷新就不用flush了
				 //pw.flush();
			 }
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		finally {
			if(bw!=null) {
				pw.close();
			}
			if(pw!=null) {
				pw.close();
			}
		}
		
		
	}
}
