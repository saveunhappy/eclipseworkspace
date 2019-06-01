package com._520if._shopping.query;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class EmployeeQueryObject extends QueryObject{

	private String keyword;
	private Date minBornDate;
	private Date maxBornDate;
	protected void customizedQuery() {
		if(StringUtils.isNotBlank(keyword)) {
			super.addQuery("username like ?", keyword);
			
		}
		if(minBornDate!=null) {
			super.addQuery("bornDate >= ?", minBornDate);
			
		}
		if(maxBornDate!=null) {
			super.addQuery("bornDate >= ?", maxBornDate);
			
		}
		

	}
}
