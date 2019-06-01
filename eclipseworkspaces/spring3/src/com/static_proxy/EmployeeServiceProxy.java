package com.static_proxy;

import com.common.TransactionManager;
import com.common.domain.Employee;
import com.common.service.IEmployeeServcie;

import lombok.Setter;

public class EmployeeServiceProxy implements IEmployeeServcie{
	@Setter
	private IEmployeeServcie target;
	@Setter
	private TransactionManager txManager;
	
	public void save(Employee emp) {
		txManager.begin();
		try {
			target.save(emp);
			txManager.commit();
		}catch(Exception e) {
			e.printStackTrace();
			txManager.rollback();
		}
	}

	

	public void update(Employee emp) {
		txManager.begin();
		try {
			target.update(emp);
			txManager.commit();
		}catch(Exception e) {
			e.printStackTrace();
			txManager.rollback();
		}
	}

}
