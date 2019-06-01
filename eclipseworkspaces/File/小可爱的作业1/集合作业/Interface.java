package com.zz;

import java.util.Scanner;

public class Interface {
	Scanner input =new Scanner(System.in);
	ListPersonManagementImpl arr=new ListPersonManagementImpl();
	public void ptint(){
	while(true){
		System.out.println("请选择功能\n1.添加单个人员\n2. 根据编号查询个人\n3.查询所有人信息"
			+ "\n4.根据id来删除某个人员信息\n5.根据id来修改name\n输入0退出");
		int i=input.nextInt();
		switch(i){
		case 1:
			Person pur=new Student();
			arr.addPerson(pur);
			continue;
		case 2:
			System.out.println("请输入查询学生得编号");
			int id=input.nextInt();
			arr.queryOnePerson(id);
			continue;
		case 3:
			arr.queryAllPersons();
			continue;
		case 4:
			System.out.print("请输入删除学生得编号：");
			int id1=input.nextInt();
			arr.deleteOnePerson(id1);
			continue;
		case 5:
			System.out.print("请输入修改学生得编号：");
			int id2=input.nextInt();
			System.out.print("请输入修改学生得姓名：");
			String name1=input.next();
			arr.updateOnePerson(id2,name1);
			continue;
		case 0:
			break;
		}
		}
}
}