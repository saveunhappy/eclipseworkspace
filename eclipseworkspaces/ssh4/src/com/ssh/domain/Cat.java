package com.ssh.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString
public class Cat extends BaseDomain{
	private Long id;
	private String name;
}
