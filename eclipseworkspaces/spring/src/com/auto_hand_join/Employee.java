package com.auto_hand_join;

import java.net.URL;

import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
public class Employee {
	private String name;
	private Integer age;
	private Double salary;
	private URL url;
}
