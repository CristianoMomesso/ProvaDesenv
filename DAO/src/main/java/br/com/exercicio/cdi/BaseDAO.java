package br.com.exercicio.cdi;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Classe que serve como base para obter os métodos basios de persistencia.
 * @author Cristiano Momesso
 *
 * @param <T>
 */
public class BaseDAO<T>{

	@Inject
	EntityManager manager;
	
	
	/**
	 * Método genérico para persistir objetos na base.
	 * @param obj
	 * @return
	 */
	public T add(T obj) {

		manager.getTransaction().begin();
		
        manager.persist(obj);

		manager.getTransaction().commit();
		
		return obj;
	}
	
}
