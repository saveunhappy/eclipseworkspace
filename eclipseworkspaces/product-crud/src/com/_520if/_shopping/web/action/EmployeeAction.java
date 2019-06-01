package com._520if._shopping.web.action;

import com._520if._shopping._dao.IEmployeeDAO;
import com._520if._shopping._dao._Impl.EmployeeDAOImpl;
import com._520if._shopping._domain.Employee;
import com._520if._shopping.page.PageResult;
import com._520if._shopping.query.EmployeeQueryObject;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;

public class EmployeeAction extends ActionSupport{


	private static final long serialVersionUID = 1L;
	private IEmployeeDAO dao = new EmployeeDAOImpl();
	@Getter
	private Employee employee = new Employee();
	@Getter
	private EmployeeQueryObject qo = new EmployeeQueryObject();
	
	//员工列表
	public String exectue() throws Exception{
		PageResult list = dao.query(qo);
		ActionContext.getContext().put("pageResult", list);
		return "list";
	}
	//删除操作
	public String delete() {
		if(employee.getId()!=null) {
			dao.delete(employee.getId());
		}
		return SUCCESS;
	}
	//进入编辑界面
	public String input() throws Exception{
		//查询需要回显的对象
		if(employee.getId()!=null) {
			employee = dao.get(employee.getId());
		}
		return INPUT;
	}
	public String save() {
		if(employee.getId()==null) {
			dao.save(employee);
		}
		else {
			dao.update(employee);
		}
		return SUCCESS;
	}
}
