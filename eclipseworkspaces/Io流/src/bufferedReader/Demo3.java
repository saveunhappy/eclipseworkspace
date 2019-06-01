package bufferedReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo3 {
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
			
			String line = br.readLine();
			
			//下一行读取数据的时候，如果没有数据的话，会得到空，null;
			//使用高效输入流可以读取一行数据
			while((line = br.readLine()) != null)
			{
				System.out.println(line);
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
