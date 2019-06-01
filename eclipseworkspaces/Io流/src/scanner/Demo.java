package scanner;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class Demo {
	public static void main(String[] args) {
		//定义学生的集合
		TreeSet<Student> ts = new TreeSet<Student>();
		
		//引入Scanner对象
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入学生的数量");
		int count = sc.nextInt();
		for(int i=0;i<count;i++) {
			sc = new Scanner(System.in);
			System.out.println("请输入学生的姓名");
			//学生的姓名
			String name = sc.nextLine();
			//学生的年龄
			System.out.println("请输入学生的年龄");
			Integer age = sc.nextInt();
			System.out.println("请输入学生的ID");
			Integer id = sc.nextInt();
			Student s = new Student();
			s.setId(id);
			s.setAge(age);
			s.setName(name);
			ts.add(s);
		}
		
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("f.txt"));
			for(Student s:ts) {
			bw.write(s.getName()+"---------"+s.getAge()+"---------"+s.getId());
				bw.newLine();
			}
			bw.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(bw != null)
			{
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("ojbk");
	}
}
