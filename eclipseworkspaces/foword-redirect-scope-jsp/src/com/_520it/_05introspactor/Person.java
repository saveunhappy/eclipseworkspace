package com._520it._05introspactor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

public class Person {
	private String username="lucy";
	private Integer age = 18;
	private String[] hobby = {"java","c","gril"};
	private List<String> list = Arrays.asList("list1","list2","list2");
	private Map<String,Object> map = new HashMap<String,Object>(){
		private static final long serialVersionUID = 1L;

		{
			this.put("company","小码哥教育");
			this.put("englishName", "see my go");
			this.put("www.xiaomage.com", "假域名");
			
		}
	};
		
}
