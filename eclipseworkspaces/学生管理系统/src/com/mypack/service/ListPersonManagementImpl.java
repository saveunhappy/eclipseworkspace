package com.mypack.service;

import java.util.ArrayList;
import java.util.List;

import com.mypack.entity.Person;

public class ListPersonManagementImpl implements PersonManagementI{
	public List<Person> list = new ArrayList<>();
	public void addPerson(Person p) {
		list.add(p);
	}

	public void queryOnePerson(int id) {
		for(int i=0;i<list.size();i++) {
			Person p  = list.get(i);
			if(p.getId()==id) {
				System.out.println(p);
			}
		}
	}

	public void queryAllPersons() {
		for(int i=0;i<list.size();i++) {
			Person p = list.get(i);
			System.out.println(p);
		}
	}

	public void deleteOnePerson(int id) {
		for(int i=0;i<list.size();i++) {
			Person p = list.get(i);
			if(p.getId()==id) {
				list.remove(p);
			}
		}
	}

	public void updateOnePerson(int id, String newName) {
		for(int i=0;i<list.size();i++) {
			Person p = list.get(i);
			if(p.getId()==id) {
				p.setName(newName);
			}
		}
	}

}
