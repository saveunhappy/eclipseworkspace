package com._520it._crm.web.action;

import com._520it._core.web.ActionContext;

//处理Employee相关的请求
public class EmployeeAction {
	
	public String execute() {
		System.out.println("....Employee...");
		String parameter = ActionContext.getContext().getRequest().getParameter("name");
		System.out.println(parameter);
		return "list";
	}
}
