package com.ssh.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.domain.Employee;
import com.ssh.service.IDepartmentService;
import com.ssh.service.IEmployeeService;

import lombok.Getter;
import lombok.Setter;

public class EmployeeAction extends BaseAction{
	@Setter
	private IDepartmentService departmentService;
	@Setter
	private IEmployeeService employeeService;
	@Getter
	private Employee employee = new Employee();
	private static final long serialVersionUID = 1L;
	public String execute() throws Exception {
		ActionContext.getContext().put("employees",employeeService.listAll());
		return LIST;
	}
	//进入录入界面
		public String input() throws Exception {
			ActionContext.getContext().put("depts",departmentService.listAll());
			if(employee.getId()!=null) {
				employee = employeeService.get(employee.getId());
			}
			return "input";
		}
		//新增或者更新
		public String saveOrUpdate() throws Exception{
			if(employee.getId()==null) {
				
				employeeService.save(employee);
			}else {
				employeeService.update(employee);
			}
			return SUCCESS;
		}
		
		public String delete() throws Exception{
				if(employee.getId()!=null) {
					
					employeeService.delete(employee);
				}
			return SUCCESS;
		}
	
		public void prepareSaveOrUpdate() throws Exception {
			if(employee.getId()!=null) {
				employee = employeeService.get(employee.getId());
			}
		}
}
