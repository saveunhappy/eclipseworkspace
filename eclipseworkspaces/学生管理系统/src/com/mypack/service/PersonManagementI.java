package com.mypack.service;

import com.mypack.entity.Person;

public interface PersonManagementI {
	public void addPerson(Person p);			//添加单个人员（即可添加老师也可学生）
	public void queryOnePerson(int id); 			// 根据编号查询某个人（老师，学生）
	public void queryAllPersons();		     	//	查询所有人信息
	public void deleteOnePerson(int id);			//
	public void updateOnePerson(int id,String newName);
}
