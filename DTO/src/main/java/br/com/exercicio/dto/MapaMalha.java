package br.com.exercicio.dto;

import java.util.List;

/**
 * Clase de entrada para o mapa da malha 
 * @author Cristiano Momesso
 *
 */
public class MapaMalha {

	/**
	 * Atributo nomeMapa do tipo String
	 */
	private String nomeMapa;
	
	/**
	 * Atributo rotas do tipo List<RotaMalha>
	 */
	private List<RotaMalha> rotas;

	/**
	 * @return nomeMapa
	 */
	public String getNomeMapa() {
		return nomeMapa;
	}

	/**
	 * @param nomeMapa
	 */
	public void setNomeMapa(String nomeMapa) {
		this.nomeMapa = nomeMapa;
	}

	/**
	 * @return rotas
	 */
	public List<RotaMalha> getRotas() {
		return rotas;
	}

	/**
	 * @param rotas
	 */
	public void setRotas(List<RotaMalha> rotas) {
		this.rotas = rotas;
	}
}
