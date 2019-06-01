package web.upload;

import org.apache.commons.io.FilenameUtils;

public class FilenameUtilsTest {
	public static void main(String[] args) {
		String path = "C:\\temp.bmp";
		//获取文件名称
		System.out.println(FilenameUtils.getName(path));
		//获取基本名称不包括拓展名
		System.out.println(FilenameUtils.getBaseName(path));
		//获取拓展名
		System.out.println(FilenameUtils.getExtension(path));
	}
}
