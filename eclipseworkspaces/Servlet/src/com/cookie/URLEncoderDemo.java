package com.cookie;

import java.net.URLDecoder;

public class URLEncoderDemo {
	public static void main(String[] args) throws Exception {
		
		String msg = "西门吹雪";
		String reg = java.net.URLEncoder.encode(msg, "UTF-8");
		System.out.println(reg);
		String str = URLDecoder.decode(msg, "UTF-8");
		System.out.println(str);
	}
}
