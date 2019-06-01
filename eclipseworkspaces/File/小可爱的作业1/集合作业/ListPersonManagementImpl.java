package com.zz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListPersonManagementImpl {
	List <Person> pList=new ArrayList();
	List <Person> tList=new ArrayList();
	Person stu=new Student();
	Person tea=new Teacher();
	Scanner input=new Scanner(System.in);
	public void addPerson(Person s1){
		System.out.println("请选择添加老师还是学生1.学生2.老师");
		int a=input.nextInt();
		if(a==1){
			System.out.println("请输入学生的编号：");
			int b=input.nextInt();
			System.out.println("请输入学生的姓名：");
			String c=input.next();
			System.out.println("请输入学生的年龄：");
			int d=input.nextInt();
			Person ps=new Student(b,c,d);
			pList.add(ps);
		}else if(a==2){
			System.out.println("请输入老师的编号：");
			int b=input.nextInt();
			System.out.println("请输入老师的姓名：");
			String c=input.next();
			System.out.println("请输入老师的年龄：");
			int d=input.nextInt();
			Person ps2=new Teacher(b,c,d);
			tList.add(ps2);
		}else{
			System.out.println("请输入正确的数字");
		}
	}
	public void queryOnePerson(int id){
		System.out.println("请选择查询学生还是老师：1.学生2.老师");
		int a=input.nextInt();
		if(a==1){
			Student s=(Student) pList.get(1);
			if(s.getId()==a){
				pList.get(a);
			}
		}else if(a==2){
			Teacher y=(Teacher) tList.get(1);
			if(y.getId()==a){
				tList.get(a);
			}
		}else{
			System.out.println("请输入正确的数字");
		}
	}
	public void queryAllPersons(){
		System.out.println("学生\n");
		for(Person p:pList){
			p.print();
		}
		System.out.println("-------------------------");
		System.out.println("老师\n");
		for(Person t:tList){
			t.print();
		}
	}
	public void deleteOnePerson(int id){
		System.out.println("请选择删除学生还是老师：1.学生2.老师");
		int a=input.nextInt();
		if(a==1){
			Student s=(Student) pList.get(1);
			if(s.getId()==a){
				pList.remove(a);
			}
		}else if(a==2){
			Teacher y=(Teacher) tList.get(1);
			if(y.getId()==a){
				tList.remove(a);
			}
		}else{
			System.out.println("请输入正确的数字");
		}
	}
	public void updateOnePerson(int id,String newName){
		System.out.println("请选择更改学生还是老师：1.学生2.老师");
		int a=input.nextInt();
		if(a==1){
			Student s=(Student) pList.get(1);
			if(s.getId()==a){
				((Person) pList.get(id)).setName(newName);
			}
		}else if(a==2){
			Teacher y=(Teacher) tList.get(1);
			if(y.getId()==a){
				((Person) tList.get(id)).setName(newName);
			}
		}else{
			System.out.println("请输入正确的数字");
		}
	}
}
