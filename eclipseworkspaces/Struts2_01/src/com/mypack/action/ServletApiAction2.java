package com.mypack.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ServletApiAction2 extends ActionSupport{

	
	private static final long serialVersionUID = 1L;
	public String execute() throws Exception{
		
		System.out.println("........"+ServletActionContext.getRequest().getParameter("name"));
		ServletActionContext.getRequest().setAttribute("requestName", "requestValue");
		ServletActionContext.getRequest().getSession().setAttribute("sessionName", "sessionValue");
		return "haha";
	}
}
