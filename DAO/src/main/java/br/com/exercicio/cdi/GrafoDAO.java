package br.com.exercicio.cdi;

import java.util.List;

import javax.persistence.Query;

import br.com.exercicio.entities.Grafo;

public class GrafoDAO  extends BaseDAO<Grafo>  {

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
