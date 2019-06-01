package com.ssh.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Permission extends BaseDomain{
	private String name;
	private String expression;
}
