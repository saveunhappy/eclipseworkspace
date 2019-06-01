package bufferedReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo1 {
	public static void main(String[] args) {
		reader();
		
	}
	
	public static void reader()
	{
		FileReader fr = null;
		
		BufferedReader br = null;
		
		try {
			fr = new FileReader("c.txt");
			
			br = new BufferedReader(fr);
			
			int num = -1;
			
			while((num=br.read()) != -1) {
				System.out.print((char)num);
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
