package br.com.exercicio.cdi;

import java.util.List;

import javax.persistence.Query;

import br.com.exercicio.entities.Grafo;

/**
 * classe que realiza manipulações referente ao grafo na base
 * @author Cristiano Momesso
 *
 */
public class GrafoDAO  extends BaseDAO<Grafo>  {

	/**
	 * Método que busca grafo na base.
	 * @param nome
	 * @return
	 */
	public Grafo buscaGrafo(String nome) {
		try {
			Query query = manager.createQuery("select m from Grafo m where m.nomeMapa like :nome");
			query.setParameter("nome", nome);
			List results = query.getResultList();
			if (results.isEmpty())
				return null;
			else if (results.size() == 1)
				return (Grafo) results.get(0);

		} catch (Exception e) {
			throw e;
		}
		return null;
	}

}
