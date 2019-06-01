package com.ssh.service.impl;

import java.util.List;

import com.ssh.dao.IDepartmentDAO;
import com.ssh.domain.Department;
import com.ssh.service.IDepartmentService;

import lombok.Setter;

public class DepartmentServiceImpl implements IDepartmentService{
	@Setter
	private IDepartmentDAO departmentDAO;
	public void save(Department e) {
		departmentDAO.save(e);
		//throw new RuntimeException("我故意的");
	}

	public void update(Department e) {
		departmentDAO.update(e);
	}

	public void delete(Long e) {
		departmentDAO.delete(e);
	}

	public Department get(Long id) {
		return departmentDAO.get(id);
	}

	public List<Department> listAll() {
		return departmentDAO.listAll();
	}





}
