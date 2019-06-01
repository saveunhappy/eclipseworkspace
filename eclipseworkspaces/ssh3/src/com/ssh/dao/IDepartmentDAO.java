package com.ssh.dao;

import java.util.List;

import com.ssh.domain.Department;

public interface IDepartmentDAO {
	void save(Department e);
	
	void update(Department e);
	
	void delete(Department e);
	
	Department get(Long id);
	
	List<Department> listAll();
	
	
}
