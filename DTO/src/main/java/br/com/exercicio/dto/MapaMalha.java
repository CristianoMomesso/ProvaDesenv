package br.com.exercicio.dto;

import java.util.List;

public class MapaMalha {

	private String nomeMapa;
	
	private List<RotaMalha> rotas;

	public String getNomeMapa() {
		return nomeMapa;
	}

	public void setNomeMapa(String nomeMapa) {
		this.nomeMapa = nomeMapa;
	}

	public List<RotaMalha> getRotas() {
		return rotas;
	}

	public void setRotas(List<RotaMalha> rotas) {
		this.rotas = rotas;
	}
}
