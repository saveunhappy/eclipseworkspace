package com.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//事物管理器
public class TransactionManager {
	//切入点语法
	public void txPoint() {
		
	}
	public void begin() {
		System.out.println("开始事物");
	}
	public void commit() {
		System.out.println("提交事物");
	}
	public void rollback() {
		System.out.println("回滚事物");
	}
}
