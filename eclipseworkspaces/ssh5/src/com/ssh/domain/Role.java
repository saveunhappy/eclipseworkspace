package com.ssh.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Role extends BaseDomain{
	private String name;
	private String sn;
	List<Permission> permission = new ArrayList<>();
}
