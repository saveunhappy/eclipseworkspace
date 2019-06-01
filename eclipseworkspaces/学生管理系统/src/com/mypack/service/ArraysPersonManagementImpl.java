package com.mypack.service;

import com.mypack.entity.Person;

public class ArraysPersonManagementImpl implements PersonManagementI{
	public Person[] arr = new Person[100];
	public static int index = 0;
	@Override
	public void addPerson(Person p) {
		arr[index] = p;
		index++;
	}

	@Override
	public void queryOnePerson(int id) {
		for(int i=0;i<index;i++) {
			Person p = arr[i];
			if(p.getId()==id) {
				System.out.println(p);
			}
		}
		
	}

	@Override
	public void queryAllPersons() {
		for(int i=0;i<index;i++) {
			Person p = arr[i];
			System.out.println(p);
		}
	}

	@Override
	public void deleteOnePerson(int id) {
		for(int i=0;i<index;i++) {
			Person p = arr[i];
			if(p.getId()==id) {
				for(int j=i;j<index-1;j++) {
					arr[j] = arr[j+1];
				}
			}
		}
		index--;
	}

	@Override
	public void updateOnePerson(int id, String newName) {
		for(int i = 0;i<index;i++) {
			Person p = arr[i];
			if(p.getId()==id) {
				p.setName(newName);
			}
		}
	}

}
