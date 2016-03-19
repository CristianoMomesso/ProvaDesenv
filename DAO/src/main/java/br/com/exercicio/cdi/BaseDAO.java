package br.com.exercicio.cdi;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class BaseDAO<T>{

	@Inject
	EntityManager manager;
	
	
	public T add(T obj) {

		manager.getTransaction().begin();
		
        manager.persist(obj);

		manager.getTransaction().commit();
		
		return obj;
	}
	
}
