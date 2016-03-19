package br.com.exercicio.comparators;

import java.util.Comparator;

import br.com.exercicio.entities.Vertice;

public class VerticeComparator implements Comparator<Vertice> {

	@Override
	public int compare(Vertice o1, Vertice o2) {
		return o2.getNomeVertice().
	                compareTo(o1.getNomeVertice());
	}

}
