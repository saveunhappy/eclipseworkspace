package com._04.factorybean;

import org.springframework.beans.factory.FactoryBean;

public class SomeBean4FactoryBean implements FactoryBean<SomeBean4>{
	//实例工厂方法：创建当前类的对象
	public SomeBean4 getObject() throws Exception {
		return new SomeBean4();
	}
	//返回对象的类型
	public Class<?> getObjectType() {
		return SomeBean4.class;
	}
	//是否把该对象做成单利
	public boolean isSingleton() {
		return true;
	}

}
