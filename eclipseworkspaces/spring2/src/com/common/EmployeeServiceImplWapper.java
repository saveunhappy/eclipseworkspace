package com.common;

import com.common.domain.Employee;
import com.common.service.IEmployeeServcie;
import com.common.service.impl.EmployeeServiceImpl;

public class EmployeeServiceImplWapper implements IEmployeeServcie{
	private IEmployeeServcie target;
	private TransactionManager txManager;
	public EmployeeServiceImplWapper(IEmployeeServcie target, TransactionManager txManager) {
		this.target = target;
		this.txManager = txManager;
	}

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
