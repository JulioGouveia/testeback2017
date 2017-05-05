package br.com.testeback2017.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("testeback2017");
	
	public  EntityManager createEntityManager(){
		return emf.createEntityManager();
	}
	
}
