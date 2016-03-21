package br.com.exercicio.impl;

import java.util.List;

import br.com.exercicio.entities.Vertice;

public class GrafoBusinessUtils {

	public Vertice criaVertice(String p) {
		Vertice verti = new Vertice();
		verti.setNomeVertice(p);
		return verti;
	}

	public Vertice addVerticet(Vertice verticet,List<Vertice> vertices) {
		vertices.add(verticet);
		return verticet;
	}

	public Vertice buscaVertice(String vert, List<Vertice> vertices) {
		if (vertices != null) {
			for (Vertice v : vertices) {
				if (v.getNomeVertice().toUpperCase().equals(vert.toUpperCase())) {
					return v;
				}
			}
		}
		return null;
	}

}
