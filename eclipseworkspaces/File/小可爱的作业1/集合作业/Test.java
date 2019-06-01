package com.zz;

import java.util.Scanner;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		ListPersonManagementImpl arr=new ListPersonManagementImpl();
		Interface inter=new Interface();
		Student s1 = new Student(1, "张三",18);
		Student s2 = new Student(2, "李四",17);
		Student s3 = new Student(3, "王五",19);
		arr.pList.add(s1);
		arr.pList.add(s2);
		arr.pList.add(s3);
		inter.ptint();
	}

}
