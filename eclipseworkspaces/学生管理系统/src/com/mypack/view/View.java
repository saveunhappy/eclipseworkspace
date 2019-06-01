package com.mypack.view;

import java.util.Scanner;

import com.mypack.entity.sub.Student;
import com.mypack.entity.sub.Teacher;
import com.mypack.service.ListPersonManagementImpl;
import com.mypack.service.PersonManagementI;

public class View {
	Scanner sc = new Scanner(System.in);
	PersonManagementI pm=new ListPersonManagementImpl();
	public void start(){
		
		while (true) {
			System.out.println("\t人员管理系统");
			System.out.println("=========================");
			System.out.println("1.\t 添加单个人员");
			System.out.println("2.\t 查询所有人员");
			System.out.println("3.\t 查询单个人员");
			System.out.println("4.\t 删除单个人员");
			System.out.println("5.\t 修改单个人员");
			System.out.println("0.\t 退出系统");
			System.out.println("=========================");
			System.out.println("请选择《0-5》");
			
			int num = sc.nextInt();
			if(num==0){
				System.out.println("退出系统");
				break;
			}
			switch (num) {
			case 1:showAddOne();
				break;
			case 2:showQueryAll();
				break;
			case 3:showQueryOne();
				break;
			case 4:showDeleteOne();
				break;
			case 5:showUpdateOne();
				break;
			default:
				System.out.println("您输入的数据不合法！！！请重新输入。。。。");
			}
		}
		
	}
	private void showUpdateOne() {
		System.out.println("请输入要更新人员的编号");
		int id = sc.nextInt();
		System.out.println("请输入要更新人员的新姓名");
		String newName = sc.next();
		pm.updateOnePerson(id, newName);
		
	}
	private void showDeleteOne() {
		System.out.println("请输入要删除人员的编号");
		int id = sc.nextInt();
		pm.deleteOnePerson(id);
	}
	private void showQueryOne() {
		System.out.println("请输入要查询人员的编号");
		int id = sc.nextInt();
		pm.queryOnePerson(id);
	}
	private void showQueryAll() {
		pm.queryAllPersons();
		
		
	}
	private void showAddOne() {
		System.out.println("请选择：1.添加老师   2.添加学生");
		int n = sc.nextInt();
		if(n==1) {
			System.out.println("请输入添加老师的姓名");
			String name = sc.next();
			System.out.println("请输入添加老师的编号");
			int id = sc.nextInt();
			System.out.println("请输入老师的薪水");
			String salary = sc.next();
			System.out.println("请输入老师教的课程");
			String course = sc.next();
			Teacher t = new Teacher(name, id, salary, course);
			pm.addPerson(t);
		}
		else if(n==2) {
			System.out.println("请输入添加学生的姓名");
			String name = sc.next();
			System.out.println("请输入添加学生的编号");
			int id = sc.nextInt();
			System.out.println("请输入学生的作业");
			String homeWork = sc.next();
			System.out.println("请输入学生的身高");
			int height = sc.nextInt();
			Student s = new Student(name, id, homeWork, height);
			pm.addPerson(s);
		}else {
			System.out.println("您输入的不合法，请重新输入");
		}
		
	}

}
