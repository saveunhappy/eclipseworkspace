package 字符串编码解析;

import java.io.UnsupportedEncodingException;

public class Demo1 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String str = "中国";
		//使用默认编码
		byte[] gbk = str.getBytes("GBK");
		//使用utf-8来编码
		byte[] Utf = str.getBytes("UTF-8");
//		打印编码值
		printByte(gbk);
		System.out.println(new String(gbk));
		//编码必须一致！！！！
//		打印用utf-8编码对应的字符串
		printByte(Utf);
		System.out.println(new String(Utf,"UTF-8"));
	}
	public static void printByte(byte[] bs) {
		for(byte b: bs) {
			System.out.print(b);
		}
	}
}
