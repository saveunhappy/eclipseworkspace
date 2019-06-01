package com.mypack.test;

import java.util.List;

import com.mypack.dao.IStudentDAO;
import com.mypack.dao.impl.IStudentDAOImpl;
import com.mypack.domain.Student;

public class Sss {
	public static void main(String[] args) {
		IStudentDAO dao = new IStudentDAOImpl();
		List<Student> list = dao.listAll();
		for (Student stu : list) {
			System.out.println(stu);
		}
	}
}
