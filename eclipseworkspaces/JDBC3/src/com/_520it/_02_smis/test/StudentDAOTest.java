package com._520it._02_smis.test;

import java.util.List;

import org.junit.Test;

import com._520it._02_smis.dao.IStudentDAO;
import com._520it._02_smis.dao.impl.IStudentDAOImpl;
import com._520it._02_smis.domain.Student;

public class StudentDAOTest {
	
	private IStudentDAO dao = new IStudentDAOImpl();
	@Test
	public void testSave() {
		Student stu = new Student();
		stu.setName("阿彪");
		stu.setAge(20);
		dao.save(stu);
	}

	@Test
	public void testDelete() {
		dao.delete(9L);
	}

	@Test
	public void testUpdate() {
		Student stu = new Student();
		stu.setName("阿彪");
		stu.setAge(12);
		dao.update(9L,stu);
	}

	@Test
	public void testGet() {
		Student stu = dao.get(1L);
		System.out.println(stu);
		
	}

	@Test
	public void testListAll() {
		List<Student> list = dao.listAll();
		for (Student stu : list) {
			System.out.println(stu);
		}
	}

}
