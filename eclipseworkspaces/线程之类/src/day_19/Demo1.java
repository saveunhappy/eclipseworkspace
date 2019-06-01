package day_19;

import java.io.File;

public class Demo1 {
	public static void main(String[] args) {
		File dir = new File("C:\\Users\\侯江涛\\Desktop\\123");
		//获得目录下的所有文件
		File[] fs = dir.listFiles();
		//需要被替换或者删除的文字
		String deleteText = "任小龙老师";
		for (File file : fs) {
			//如果文件的名字包含上面字符串中的文字
			if(file.getName().contains(deleteText)) {
				//将里面的东西都给替换了，
				String newFile = file.getName().replaceAll(deleteText, "hh");
				file.renameTo(new File(dir,newFile));
			}
		}
	}
}
