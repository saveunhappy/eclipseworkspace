package file;

import java.io.File;

public class FileDemo4 {
	public static void main(String[] args) {
		//列出系统的根，盘符
		File[] files = File.listRoots();
		for(File f:files) {
			System.out.println(f);
		}
		//获得指定目录下的子文件只是子文件，而且还有层级关系
		File file = new File("C:\\Users\\侯江涛\\Desktop\\js练习用的");
		File[] files1 = file.listFiles();
		for(File s : files1)
		{
			System.out.println(s);
		}
		//获得所有子文件的名字，就单纯的打印出来
		String[] fils2 = file.list();
		for(String s1 : fils2) {
			System.out.println(s1);
		}
	}
}
