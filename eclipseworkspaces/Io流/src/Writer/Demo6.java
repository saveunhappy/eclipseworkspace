package Writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Demo6 {
	public static void main(String[] args){


		FileWriter fw = null;
		try {
			
			/**
			 * 内容为了兼容记事本，用\r\n  \r要在前面
			 */
			//最后还是要flush一下，如果后面的不够十个的话就不清理了，所以还得做一次最后的清理
			//其实不清空也是可以的，因为下面的close在调用的时候会自动调用flush，但还是建议调用一下。
			
			
			fw =  new FileWriter("Text.txt"); 
			char[] cs = {'a','b','c','d'};
			fw.write(cs);
			//，第一个是字符数组，第二个参数是索引，第三个是长度
			fw.write(cs, 1, 2);
			fw.flush();
			//转成字符了，ascll码了
			fw.write(100);
			fw.write("100");
			fw.write("helloworld", 2, 2);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if(fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
