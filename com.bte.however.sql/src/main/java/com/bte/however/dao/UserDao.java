/**
 * 
 */
package com.bte.however.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.eclipse.persistence.expressions.ExpressionBuilder;
import org.eclipse.persistence.jpa.JpaEntityManager;
import org.eclipse.persistence.jpa.JpaHelper;
import org.eclipse.persistence.sessions.Project;

import com.bte.however.domain.UserDomain;
import com.bte.however.exception.UserNotFoundException;
import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.User;

/**
 * Data Access Object asociado al usuario
 * 
 * @author benauca
 *
 */
public class UserDao {

	/**
	 * 
	 * @return
	 */
	public List<UserDomain> findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hvrDomain");
		EntityManager em = emf.createEntityManager();
		return em.createNamedQuery("UserDomain.findAll").getResultList();
	}

	/**
	 * Añade un usuario al Sistema.
	 * 
	 * @param theUser
	 */
	public void persits(UserDomain theUser) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hvrDomain");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(theUser);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	/**
	 * 
	 * @param theUser
	 */
	public void delete(UserDomain theUser) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hvrDomain");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			theUser = em.getReference(UserDomain.class, theUser.getIdUser());
			em.remove(theUser);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	/**
	 * 
	 * @param idUser
	 * @return
	 * @throws UserNotFoundException
	 */
	public UserDomain findUserById(Integer idUser) throws UserNotFoundException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hvrDomain");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		UserDomain anUser = em.getReference(UserDomain.class, idUser);
		if (anUser == null)
			throw new UserNotFoundException("Usuario no encontrado con el id " + idUser);
		return anUser;
	}

	/**
	 * 
	 * @param email
	 * @return
	 * @throws UserNotFoundException
	 */
	public UserDomain findUserByEmail(String email) throws UserNotFoundException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hvrDomain");
		EntityManager em = emf.createEntityManager();
		CriteriaBuilder qb = em.getCriteriaBuilder();
		CriteriaQuery<UserDomain> query = qb.createQuery(UserDomain.class);
		Root<UserDomain> anUser = query.from(UserDomain.class);
		query.where(qb.equal(anUser.get("email"), email));
		List<UserDomain> result = em.createQuery(query).getResultList();

		if (result == null)
			throw new UserNotFoundException("Usuario no encontrado con el email " + email);

		if (result.size() == 0)
			throw new UserNotFoundException("Usuario no encontrado con el id " + email);
		return result.get(0);

	}
}
