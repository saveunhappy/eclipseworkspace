package com.ssh.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class BaseAction extends ActionSupport implements Preparable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String LIST = "list";
	public void prepare() throws Exception {
		
	}
	public void putContext(String name,Object value) {
		ActionContext.getContext().put(name,value);
	}

}
