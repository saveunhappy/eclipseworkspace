package com.mypack.login;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckLoginInterceptor extends AbstractInterceptor{
	private List<String> unCheckActionName;
	public void setunCheckLogin(String name) {
		unCheckActionName =  Arrays.asList(name.split(","));
	}
	public String intercept(ActionInvocation invocation) throws Exception {
		
		//检查用户是否登录
		//从session中获取登录信息
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		Object currentName = session.get("USER_IN_SESSION");
		String actionName = invocation.getProxy().getActionName();
		if(currentName==null&&!unCheckActionName.contains(actionName)) {
			return Action.LOGIN;
		}
		return invocation.invoke();
	}

}