package com.mypack.dao;

import java.util.List;

import com.mypack.domain.Student;

public interface IStudentDAO {
	void save(Student stu);
	
	void delete(Long id);
	
	void update(Student stu);
	
	Student get(Long id);
	
	List<Student> listAll();
}
