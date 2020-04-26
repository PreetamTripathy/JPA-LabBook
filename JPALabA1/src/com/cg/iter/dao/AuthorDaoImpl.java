package com.cg.iter.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cg.iter.entity.Author;
import com.cg.iter.JpaUtil.JpaUtil;
import com.cg.iter.entity.Author;

public class AuthorDaoImpl implements AuthorDao {

	@Override
	public boolean create(Author auth) {
		boolean created = false;
		try {
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(auth);
		em.getTransaction().commit();
		created = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return created;
	}
	@Override
	public Author getAuth(int AuthorId) {
		Author auth = null;
		try{
			EntityManager em = JpaUtil.getEntityManager();
			auth = em.find(Author.class, AuthorId);
		
		}
		catch(Exception e){			
		}
		return auth;
		
	}
	@Override
	public boolean update(Author auth) {
		boolean updated=false;
		try{
			EntityManager em = JpaUtil.getEntityManager();
			EntityTransaction et = em.getTransaction();
			em.getTransaction().begin();
			em.merge(auth);
			em.getTransaction().commit();
			updated = true;
		}
		catch(Exception e){
		}
		return updated;
	}
	@Override
	public boolean delete(Author auth) {
		boolean deleted=false;
		try{
			EntityManager em = JpaUtil.getEntityManager();
			EntityTransaction et = em.getTransaction();
			em.getTransaction().begin();
			em.remove(auth);
			em.getTransaction().commit();
			deleted = true;
		}
		catch(Exception e){
		}
		return deleted;
	}
}

