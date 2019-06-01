package com.mypack.query;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeQueryObject {
	private String keyword;// 关键字，员工的名字或者员工的编号
	private BigDecimal minSalary;
	private BigDecimal maxSalary;
	private Long deptId = -1L;
	private int currentPage = 1;
	private int pageSize = 3;

	public int getStart() {
		return (currentPage - 1) * pageSize;
	}

	public String getKeyword() {
		return empty2null(keyword);
	}

	public String empty2null(String str) {
		return hasLength(str) ? str : null;
	}

	private boolean hasLength(String str) {
		return str != null && !"".equals(str.trim());
	}

}
