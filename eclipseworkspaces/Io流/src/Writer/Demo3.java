package Writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Demo3 {
	public static void main(String[] args){


		FileWriter fw = null;
		try {
			//直接在FieWriter里面添加就行了，都不用创建文件了

			fw =  new FileWriter("a.txt"); 
			for(int i = 0; i < 100 ; i++) {
				fw.write("hello");
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
