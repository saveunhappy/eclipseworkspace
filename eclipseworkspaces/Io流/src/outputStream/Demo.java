package outputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Demo {
	
		public static void main(String[] args) {
			writerFile();
			// System.out.println("done");
		}
		public static void writerFile() {
			OutputStream out  =null;
			
			try {
				/**
		追加	out = new FileOutputStream("e.txt",true);
				 * 
				 */
			out = new FileOutputStream("e.txt");
			String str = "helloworldaaaaaaaaa";
			byte [] bs = str.getBytes();
//			out.write(bs);
//		out.write(bs);   	和下面一样
			for(byte b:bs) {
				out.write(b);
				
				
				//System.out.print((char)b);
			}
			out.flush();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(out!=null) {
					try {
						out.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
}
