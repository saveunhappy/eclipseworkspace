package bufferedWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Demo1 {
	public static void main(String[] args) {
		wirter();
		
		
	}
	/**
	 * 高效缓冲区
	 */
	public static void wirter()
	{
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter("d.txt");
			//创建高效缓冲区的对象
			bw = new BufferedWriter(fw);
			//输出数据
			for(int i=0 ; i<10; i ++) {
			bw.write("java太好学了，太简单了");
//			换行，相当于\r\n
			bw.newLine();
			}
			//清空缓冲区
			bw.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(bw!=null) {
				try {
					//关闭缓冲区的流，会自动关闭FIlewriter
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
