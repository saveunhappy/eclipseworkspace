package com.jdk__proxy.proxy;

import com.jdk__proxy.domain.Employee;
import com.jdk__proxy.service.IEmployeeService;
import com.jdk__proxy.tx.TransactionManager;

public class EmployeeServiceProxy implements IEmployeeService{
	
	private TransactionManager txManager;
	public void setTxManager(TransactionManager txManager) {
		this.txManager = txManager;
	}
	private IEmployeeService target;//真实对象、委托对象
	public void setTarget(IEmployeeService target) {
		this.target = target;
	}
	public void save(Employee emp) {
		txManager.begin();
		try {
			
			target.save(emp);
			txManager.commit();
		}catch (Exception e) {
			System.out.println(e);
			txManager.rollback();
		}
		
	}

	public void update(Employee emp) {
		target.update(emp);
	}

}
