package file;

import java.io.File;

public class FileDemo6 {
	public static int level = 1;
	public static void main(String[] args) {
		File file = new File("C:\\Users\\侯江涛\\Desktop\\17级软信、移动专业JavaScript暑假作业");
		printFile(file);
		
	}
	/**
	 * 遍历文件夹下的所有文件
	 */
	public static void printFile(File file) {
		if(!file.isDirectory()) {
			return;
			//viod 的时候直接加return就结束了
		}
		if(!file.exists()) {
			return;
		}
		level++;
		//遍历文件夹内部的文件
		File[] files  = file.listFiles();
		for(File file1:files) {
			for(int i=0;i<level;i++) { 
				System.out.print("\t");
				
				//!!!这里是print，不是println!!!!
			}
			String name = file1.getName();
			System.out.println(name);
			printFile(file1);
			/*
			if(file1.isDirectory()) {
				//递归调用
				printFile(file1);
			}
			*/
			
		}
		
		level--;
	}
}
