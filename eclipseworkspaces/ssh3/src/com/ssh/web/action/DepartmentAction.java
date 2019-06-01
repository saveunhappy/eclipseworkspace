package com.ssh.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.domain.Department;
import com.ssh.service.IDepartmentService;

import lombok.Getter;
import lombok.Setter;

public class DepartmentAction extends BaseAction{

	@Getter
	private Department department = new Department();
	@Setter
	private IDepartmentService departmentService;
	private static final long serialVersionUID = 1L;
	//查询列表
	public String execute() throws Exception {
		ActionContext.getContext().put("department", departmentService.listAll());
		return LIST;
	}
	//进入录入界面
	public String input() throws Exception {
		if(department.getId()!=null) {
			department = departmentService.get(department.getId());
		}
		return "input";
	}
	//新增或者更新
	public String saveOrUpdate() throws Exception{
		if(department.getId()==null) {
			
			departmentService.save(department);
		}else {
			departmentService.update(department);
		}
		return SUCCESS;
	}
	
	public String delete() throws Exception{
			if(department.getId()!=null) {
				
				departmentService.delete(department);
			}
		return SUCCESS;
	}
}
