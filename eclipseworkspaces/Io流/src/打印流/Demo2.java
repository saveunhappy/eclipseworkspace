package 打印流;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Demo2 {
	public static void main(String[] args) {
		PrintWriter pw = null;
		BufferedReader bw = null;
		try {
			 pw = new PrintWriter(System.out);
			//自动刷新
			 pw = new PrintWriter(System.out,true);
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
