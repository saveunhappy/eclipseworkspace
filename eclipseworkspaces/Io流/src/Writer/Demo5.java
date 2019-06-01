package Writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Demo5 {
	public static void main(String[] args){


		FileWriter fw = null;
		try {
			//直接在FieWriter里面添加就行了，都不用创建文件了
			//两个参数就是追加，不是的话就是覆盖了 
			/**
			 * 内容为了兼容记事本，用\r\n  \r要在前面
			 */
			fw =  new FileWriter("b.txt",true); 
			for(int i = 0; i < 100 ; i++) {
				fw.write("hello"+i+"\r\n");
				//到一定的时候清空一下
				if(i%10==0) {
					//字符流的特点：清空缓冲区，把内容写入到文件中
					fw.flush();
					
				}
				
			}
			//最后还是要flush一下，如果后面的不够十个的话就不清理了，所以还得做一次最后的清理
			//其实不清空也是可以的，因为下面的close在调用的时候会自动调用flush，但还是建议调用一下。
			
			fw.flush();
			
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
