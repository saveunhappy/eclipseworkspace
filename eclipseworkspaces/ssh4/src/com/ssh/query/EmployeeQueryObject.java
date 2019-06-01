package com.ssh.query;

import lombok.Getter;
import lombok.Setter;

/*
 *	员工的高级查询对象，封装了高级查询信息 
 */
public class EmployeeQueryObject extends QueryObject {
	@Getter@Setter
	private String keyword;//查询名称或者邮箱
	@Getter@Setter
	private Long deptId = -1L;
	public EmployeeQueryObject()
	{
		deptId = Long.valueOf(-1L);
	}
	public void customizedQuery()
	{
		if (hasLength(keyword))
			super.addQuery("(obj.name LIKE ? OR obj.email LIKE ?)", new Object[] {
				(new StringBuilder()).append("%").append(keyword).append("%").toString(), (new StringBuilder()).append("%").append(keyword).append("%").toString()
			});
		if (deptId.longValue() != -1L)
			super.addQuery("obj.dept.id = ?", new Object[] {
				deptId
			});
	}

	@Override
	public String toString() {
		return "EmployeeQueryObject [keyword=" + keyword + ", deptId=" + deptId + "]";
	}
	
	//带有查询条件的HQL，如： where (obj.name like ? or obj.email like ?) and obj.dept.id = ?
	
	
}
