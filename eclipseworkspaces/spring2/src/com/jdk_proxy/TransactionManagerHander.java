package com.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.common.TransactionManager;

import lombok.Setter;

public class TransactionManagerHander implements InvocationHandler{
	@Setter
	private Object target;//真实对象：(被代理对象，EmployeeServiceImpl)
	@Setter
	private TransactionManager txManager;
	public <T>T getProxyObject() {
		Object obj= Proxy.newProxyInstance(target.getClass().getClassLoader(),//类加载器
				target.getClass().getInterfaces(),
				this);
		return (T)obj;
	}
		
	//在真实对象上做增加操作
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			txManager.begin();
			Object invoke = null;
			try {
				invoke = method.invoke(target, args);
				txManager.commit();
			}catch(Exception e) {
				txManager.rollback();
			}
			
		return invoke;
	}
	
}
