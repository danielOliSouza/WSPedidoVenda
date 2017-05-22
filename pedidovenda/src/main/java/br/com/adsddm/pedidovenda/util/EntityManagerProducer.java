package br.com.adsddm.pedidovenda.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityManagerProducer {

	private static EntityManagerFactory factory = 
			Persistence.createEntityManagerFactory("BD_PV");
	
	public static EntityManager createEntityManager() {
		return factory.createEntityManager();
	}

}