package br.com.exercicio.comparators;

import java.util.Comparator;

import br.com.exercicio.entities.Vertice;

/**
 * Classe comparator utilizada na priorityqueue na geração do menor caminho
 * @author Cristiano Momesso
 *
 */
public class VerticeComparator implements Comparator<Vertice> {

	/*
	 * Override do método compare
	 */
	@Override
	public int compare(Vertice o1, Vertice o2) {
		return o2.getNomeVertice().
	                compareTo(o1.getNomeVertice());
	}

}
