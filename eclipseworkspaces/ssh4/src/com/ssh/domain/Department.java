package com.ssh.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString
public class Department extends BaseDomain{
	private Long id;
	private String name;
	private String sn;
}
