package com.mypack.domain;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter@Setter@ToString
public class User {
	private Long id;
	private String name;
	private BigDecimal salary;
	private java.util.Date hiredate;
	
}
