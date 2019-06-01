package com.mypack.mapper;

import com.mypack.domain.Department;

public interface DepartmentMapper {
	void save(Department department);

	Department get(Long id);
}
