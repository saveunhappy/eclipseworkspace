package com.ssh.service;

import java.util.List;

import com.ssh.domain.Department;

public interface IDepartmentService {
	void save(Department e);
	
	void update(Department e);
	
	void delete(Department id);
	
	Department get(Long id);
	
	List<Department> listAll();
	
}
