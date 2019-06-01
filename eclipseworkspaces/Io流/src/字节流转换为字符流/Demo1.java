package 字节流转换为字符流;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Demo1 {
	public static void main(String[] args) {
		//System类中的属性  in返回值是 static  InputStream也就是数据类型
		
		InputStream is = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		BufferedWriter bw = null;
		String line = null;
		
		try {
			bw = new BufferedWriter(new FileWriter("b.txt"));
			//不为null就可以一直输入
			while((line = br.readLine())!=null) {
				//输入exit就退出
				if("exit".equals(line)) {
					break;
				}
				//输入一行数据
				bw.write(line);
				//输入之后换一行
				bw.newLine();
				//一定要清除缓存
				bw.flush();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
}
}