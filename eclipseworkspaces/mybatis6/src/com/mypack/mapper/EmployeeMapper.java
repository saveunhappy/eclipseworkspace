package com.mypack.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mypack.domain.Employee;

public interface EmployeeMapper {

	List<Employee> query(
			@Param("minSalary")BigDecimal minSalary,
			@Param("maxSalary")BigDecimal maxSalary,
			@Param("deptId")Long deptId
			
			);
	void batchDelect(@Param("ids")Long[] ids);
	
}
