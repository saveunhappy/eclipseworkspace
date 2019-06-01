package sss;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		StudentManagement sm = new StudentManagement();
		Student s1 = new Student(1, "张三");
		Student s2 = new Student(2, "李四");
		Student s3 = new Student(3, "王五");
		sm.addStu(s1);
		sm.addStu(s2);
		sm.addStu(s3);
		while(true){
		System.out.println("请选择功能\n1.添加学生\n2.查询学生\n3.查询所有学生"
			+ "\n4.删除学生\n5.修改学生\n输入0退出");
		int i=input.nextInt();
		switch(i){
		case 1:
			System.out.println("请输入学生姓名：");
			String name=input.next();
			Student b = new Student(sm.list.size()+1, name);
			sm.addStu(b);
			continue;
		case 2:
			System.out.println("请输入查询学生得编号");
			int id=input.nextInt();
			sm.queryOneStu(id-1);
			continue;
		case 3:
			sm.queryALLStu();
			continue;
		case 4:
			System.out.print("请输入删除学生得编号：");
			int id1=input.nextInt();
			sm.deleteStu(id1-1);
			continue;
		case 5:
			System.out.print("请输入修改学生得编号：");
			int id2=input.nextInt();
			System.out.print("请输入修改学生得姓名：");
			String name1=input.next();
			sm.updateStu(id2-1,name1);
			continue;
		case 0:
			break;
		}
		}
//		sm.queryOneStu(1);
//		// 删除单个
//		sm.deleteStu(1);
//		// 查询所有学生
//		sm.queryALLStu();
//		// 修改单个
//		sm.updateStu(1, "赵六");
//		sm.queryALLStu();
		// 查询所有学生

	}

}
