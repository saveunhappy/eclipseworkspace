package com._520it._01_sims.dao;

import java.util.List;

import com._520it._01_sims.domain.Student;

public interface IStudentDAO {
	/**
	 * 保存操作
	 */
	void save(Student stu);
	/**
	 * 删除操作
	 */
	void delete(Long id);
	/**
	 * 更新操作
	 */
	void update(Long id,Student newStu);
	/**
	 * 查询指定学生的ID
	 */
	Student get(Long id);
	/**
	 * 查询并返回所有学生对象
	 */
	List<Student> listAll();
	
}
