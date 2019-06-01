package bufferedReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo2 {
	public static void main(String[] args) {
		reader();
		
	}
	
	public static void reader()
	{
		FileReader fr = null;
		
		BufferedReader br = null;
		
		try {
			fr = new FileReader("d.txt");
			
			br = new BufferedReader(fr);
			char [] chs = new char[1024];
			int num = -1;
			
			while((num=br.read(chs)) != -1) {
				System.out.print(new String(chs,0,num));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		
	}
}
