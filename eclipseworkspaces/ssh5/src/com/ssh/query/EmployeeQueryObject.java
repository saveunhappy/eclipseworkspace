package com.ssh.query;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/*
 *	员工的高级查询对象，封装了高级查询信息 
 */
public class EmployeeQueryObject  {
	@Getter@Setter
	private String keyword;//查询名称或者邮箱
	@Getter@Setter
	private Long deptId = -1L;
	
	
	
	
	private List<String> conditions = new ArrayList<>();//查询条件
	
	private List<Object> params = new ArrayList<>();//占位符参数
	
	
	public String getQuery() {
		if(hasLength(keyword)) {
			conditions.add("(obj.name like ? or obj. email like ?)");
			String key  = "%"+keyword+"%";
			params.add(key);
			params.add(key);
		}
		if(deptId>0) {
			conditions.add("obj.dept.id = ?");
			params.add(deptId);
			
		}
		if(conditions.size()==0) {
			return "";
		}
		StringBuilder sb = new StringBuilder(80);
		for(int index = 0;index < conditions.size();index++) {
			if(index==0) {
				sb.append(" where ");
				
			}else {
				sb.append(" and ");
			}
			sb.append(conditions.get(index));
		}
		return sb.toString();
		
	}
	public List<Object> getParameters() {
		return this.params;
	}
/*	public void customizedQuery() {
		if(hasLength(keyword)) {
			String key = "%" +keyword+ "%";
			
			super.addQuery("(obj.name like ? or obj.email like ?)", key,key);
		}
		if(deptId > 0) {
			super.addQuery("obj.dept.id = ?", deptId);
		}
	}*/
	
	//带有查询条件的HQL，如： where (obj.name like ? or obj.email like ?) and obj.dept.id = ?
	
	protected boolean hasLength(String str) {
		return str!=null&&!"".equals(str.trim());
	}
}
