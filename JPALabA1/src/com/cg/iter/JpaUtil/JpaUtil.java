package com.cg.iter.JpaUtil;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private static EntityManager em;
	public static EntityManager getEntityManager() {
		if(em==null) {
			EntityManagerFactory emf = 
					Persistence.createEntityManagerFactory("authentity");
			em = emf.createEntityManager();
		}
		return em;
	}

}
