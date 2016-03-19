package br.com.exercicio.cdi;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe utilizada para manipular o entitymanager e fechar as conexões abertas
 * @author Cristiano Momesso
 *
 */
public class JPAUtil {

	/**
	 * Atributo factory do tipo EntityManagerFactory
	 */
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("teste");
	
	/**
	 * Cada request cria a instancia do factory
	 * @return
	 */
	@Produces 
	@RequestScoped
	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
	/**
	 * Terminando de usar o entitymanager, é executado o disposes fechando a conexão
	 * @param em
	 */
	public void close(@Disposes EntityManager em) {
		em.close();
	}

}
