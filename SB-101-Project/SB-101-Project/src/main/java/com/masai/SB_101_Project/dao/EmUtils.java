package com.masai.SB_101_Project.dao;

import org.hibernate.event.spi.PersistContext;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmUtils {

	static EntityManagerFactory emf;
	
	 static {
		emf=Persistence.createEntityManagerFactory("SB101_project");
	}
	 public static EntityManager getEntityManager()
	{
		return emf.createEntityManager();
	}
	
	
}
