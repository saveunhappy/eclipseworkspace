package com.mypack.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String dateToString(Date date) {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String str=sdf.format(date);
		return str;

	}
	public static void main(String[] args) {
		Date date=new Date();
		
		String s=dateToString(date);
		System.out.println(s);
	}
}
