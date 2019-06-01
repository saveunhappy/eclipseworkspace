package com.mypack.domain;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.mypack.mapper.StudentMapper;
import com.mypack.mapper.TeacherMapper;
import com.mypack.util.MybatisUtil;

public class App {
	@Test
	public void test1() throws Exception {
		Teacher t1 = new Teacher();
		t1.setName("老师1");
		Teacher t2 = new Teacher();
		t2.setName("老师2");
		Student s1 = new Student();
		s1.setName("小明");
		Student s2 = new Student();
		s2.setName("小丽");
		//维护关系
		s1.getTeachers().add(t1);
		s1.getTeachers().add(t2);
		
		s2.getTeachers().add(t1);
		s2.getTeachers().add(t2);
		
		SqlSession session = MybatisUtil.getSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
		studentMapper.save(s1);
		studentMapper.save(s2);
		teacherMapper.save(t1);
		teacherMapper.save(t2);
		
		//s1学生来维护维护中间表的关系
		for(Teacher t: s1.getTeachers()) {
			studentMapper.insertRelationWithTeacher(s1.getId(), t.getId());
		}
		//s2学生来维护维护中间表的关系
		for(Teacher t: s1.getTeachers()) {
			studentMapper.insertRelationWithTeacher(s2.getId(), t.getId());
		}
			session.commit();
	}
	@Test
	public void test2() throws Exception {
		SqlSession session = MybatisUtil.getSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		//删除中间表的时候要打破关系
		studentMapper.deleteRelationWithTeacher(1L);
		studentMapper.delete(1L);
		session.commit();
	}
	@Test
	public void test3() throws Exception {
		SqlSession session = MybatisUtil.getSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		Student s = studentMapper.get(1L);
		System.out.println(s);
		System.out.println(s.getTeachers());
	}
	
}
