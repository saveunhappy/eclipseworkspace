package com.mypack.query;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
@Getter@Setter
public class EmployeeQueryObject {
	private String keyword;//关键字，员工的名字或者员工的编号
	private BigDecimal minSalary;
	private BigDecimal maxSalary;
	private Long deptId = -1L;
	
}
