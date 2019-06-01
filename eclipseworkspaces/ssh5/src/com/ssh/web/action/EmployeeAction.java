package com.ssh.web.action;

import com.ssh.domain.Employee;
import com.ssh.query.EmployeeQueryObject;
import com.ssh.query.PageResult;
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
	@Getter
	private EmployeeQueryObject qo = new EmployeeQueryObject();
	
	private static final long serialVersionUID = 1L;

	public String execute() throws Exception {
		putContext("depts",departmentService.listAll());
		
		putContext("pageResult", employeeService.query(qo));
		PageResult query = employeeService.query(qo);
	
		return LIST;
	}
	//进入录入界面
		public String input() throws Exception {
			putContext("depts",departmentService.listAll());
			if(employee.getId()!=null) {
				employee = employeeService.get(employee.getId());
			}
			return INPUT;
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
					
					employeeService.delete(employee.getId());
				}
			return SUCCESS;
		}
	
		public void prepareSaveOrUpdate() throws Exception {
			if(employee.getId()!=null) {
				employee = employeeService.get(employee.getId());
			}
		}
}
