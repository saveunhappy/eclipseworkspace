package com.query;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
@Setter@Getter
public class Employee {
	private Long id;
	private String name;
	private BigDecimal salary;
	private Date hireDate;//date
	
	private Department dept;//DEPT_ID

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", hireDate=" + hireDate + "]";
	}
	
}
