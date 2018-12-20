package com.aricionur.jsfJpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class ADao {

	EntityManager em;
	
	public ADao (){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Project");
		this.em = emf.createEntityManager();
		
	}
	
}
