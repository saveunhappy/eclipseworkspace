package reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo2 {
	public static void main(String[] args) {
	
		readFile();
		
	}
	public static void readFile() {
		FileReader fr = null;
		
		try {
			fr = new FileReader("Text.txt");
			//创建一个字符串的数组
			/*
			char[] chs = new char[5];
			//读取五个字符放入字符数组中
			int num = fr.read(chs);
			String str = new String(chs);
			System.out.println(num);
			System.out.println(chs);
			System.out.println("-----------------------");
			num = fr.read(chs);
			
				str = new String(chs,0,num);

			System.out.println(num);
			System.out.println(str);
			num = fr.read(chs);
			str = new String(chs,0,num);
			System.out.println(num);
			System.out.println(str);
			num = fr.read(chs);
			str = new String(chs,0,num);
			System.out.println(num);
			System.out.println(str);
			*/
			
			char [] cha = new char[1024];
			int num1 = -1;
			while((num1 = fr.read(cha))!= -1)
			{
				System.out.println(new String(cha,0,num1));
			}
		
		
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(fr!=null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
}
