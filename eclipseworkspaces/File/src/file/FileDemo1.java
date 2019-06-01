package file;

import java.io.File;
import java.io.IOException;

public class FileDemo1 {
	public static void main(String[] args) throws IOException  {
		File file = new File("C:\\Users\\侯江涛\\Desktop\\java异常例子\\java");
//		创建一个文件
		boolean issuccess  = file.createNewFile();
//		System.out.println(issuccess);
		//创建一个目录
//		boolean is  =file.mkdir();
//		System.out.println(is);
		//创建多级目录
//		boolean is1  =file.mkdirs();
		//删除文件不会再回收站，，，血的教训
		//删除目录的话，必须里面是空的，才能删除，否则删不掉
		boolean is2  = file.delete();
		System.out.println(is2);
		/**
		 * 
		 */
//		file.exists();是否存在
//		file.isFile();是否是文件
//		file.isAbsolute()是否是绝对路径
//		file.isDirectory();是否是目录
//		file.canWrite();是否可写
//		file.canRead();是否可读
//		file.isHidden();是否隐藏
//		不指定盘符的话，就是相对路径，相对于工程来说的
		File file1 = new File("a.txt");
		file1.createNewFile();
		
		
		
		File[] s   = file.listRoots();
		System.out.println(s);
	}
}
