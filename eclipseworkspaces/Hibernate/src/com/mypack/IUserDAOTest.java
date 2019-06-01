package com.mypack;

import java.util.List;

import org.junit.Test;

import com.mypack.dao.IUserDAO;
import com.mypack.dao.impl.UserDAOImpl;
import com.mypack.domain.User;

public class IUserDAOTest {
	private IUserDAO dao = new UserDAOImpl();
	@Test
	public void testSave() {
		User user = dao.get(1L);
		user.setName("阿彪");
		dao.save(user);
	}

	@Test
	public void testUpdate() {
		User u = dao.get(1L);
		u.setName("西门");
		dao.update(u);
	}

	@Test
	public void testDelete() {
		User u = new User();
		u.setId(1L);
		dao.delete(u);
	}

	@Test
	public void testGet() {
		User user = dao.get(1L);
		System.out.println(user);
	}

	@Test
	public void testListAll() {
		List<User> list = dao.listAll();
		for (User user : list) {
			System.out.println(user);
		}
	}

}
