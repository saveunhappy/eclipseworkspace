package com._520if._shopping._domain;

import lombok.Data;

@Data
public class Employee {
	private Long id;
	private String username;//账号
	private String password;//密码
	private String headImg="/upload/1.jpg";//默认图片地址
	private String dept;//部门
	private java.util.Date bornDate;//出生年月
}
