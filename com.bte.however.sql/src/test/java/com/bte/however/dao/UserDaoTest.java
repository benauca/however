package com.bte.however.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bte.however.domain.UserDomain;

public class UserDaoTest {
	UserDao anUserDao = null;

	@Before
	public void setUp() throws Exception {
		anUserDao = new UserDao();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindAll() {
		UserDomain anUser = this.createUser();
		anUserDao.persits(anUser);
		assertNotNull("La lista de usuarios No es Nula", anUserDao.findAll());
		int size = anUserDao.findAll().size();
		assertTrue("Existe al menos un usuario", size > 0);
		anUserDao.delete(anUser);
		assertTrue("Se ha borrado el usuario para la prueba", anUserDao.findAll().size() ==  size - 1);

	}

	private UserDomain createUser() {
		UserDomain result = new UserDomain();
		result.setAuthType(0);
		result.setEmail("test@gmail.com");
		result.setFullName("FullName");
		result.setLogin("Admin");
		return result;
	}

}
