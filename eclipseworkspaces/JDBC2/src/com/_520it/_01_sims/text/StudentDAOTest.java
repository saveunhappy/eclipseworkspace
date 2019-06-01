package com._520it._01_sims.text;

import java.util.List;

import org.junit.Test;

import com._520it._01_sims.dao.IStudentDAO;
import com._520it._01_sims.dao.impl.StudentDAOImpl;
import com._520it._01_sims.domain.Student;

public class StudentDAOTest {
	
	private IStudentDAO dao = new StudentDAOImpl();
	@Test
	public void testSave() {
		Student stu = new Student();
		stu.setName("三少爷");
		stu.setAge(27);
		dao.save(stu);
	}

	@Test
	public void testDelete() {
		dao.delete(2L);
	}

	@Test
	public void testUpdate() {
		Student stu = new Student();
		stu.setName("白小飞");
		stu.setAge(28);
		dao.update(6L, stu);
	}

	@Test
	public void testGet() {
		Student stu = dao.get(5L);
		System.out.println(stu);
		
	}

	@Test
	public void testListAll() {
		List<Student> stus = dao.listAll();
		for (Student stu : stus) {
			System.out.println(stu);
		}
	}

}
