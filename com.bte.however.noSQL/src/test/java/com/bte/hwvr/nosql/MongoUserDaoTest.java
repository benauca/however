package com.bte.hwvr.nosql;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bte.hwvr.model.User;

public class MongoUserDaoTest {

	String id = "";

	public MongoUserDaoTest() {
		// TODO Auto-generated constructor stub
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void findUser() {
		fail("");
	}

	@Test
	public void findAll() {

		EntityManager em = new MongoPersistence().getEntityManager("test2");

		List<User> users = new ArrayList<User>();
		Query queryAll = em.createNativeQuery("db.usuario.find()", User.class);
		users = queryAll.getResultList();
		assertNotNull(users);
		assertTrue(users.size() > 0);
		System.out.println(users.toString());
	}

	@Test
	public void insertUser() {
		User anUser = new User();
		anUser.setName("Jesús Benavente");
		anUser.setEmail("jbesssssssssssss@gmail.com");
		EntityManager em = new MongoPersistence().getEntityManager("test2");
		em.getTransaction().begin();
		em.persist(anUser);
//		id = anUser.getId();
		em.getTransaction().commit();

	}

	/**
	 * Uses entity manager primary key lookup.
	 */
	@Test
	public void should_find_by_primary_key() {
		EntityManager em = new MongoPersistence().getEntityManager("test2");
		// when
		User anUser = em.find(User.class, "584F2CF1704721019A6075A7");

		// then
		assertNotNull(anUser);
	}
}
