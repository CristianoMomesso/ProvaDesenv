package br.com.exercicio.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * The persistent class for the grafo database table.
 */
@Entity
public class Grafo {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int grafoId;
	
	private String nomeMapa;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "grafo",  targetEntity = Vertice.class,fetch = FetchType.EAGER)
	private List<Vertice> verticets = new ArrayList<Vertice>();
	
	public int getGrafoId() {
		return grafoId;
	}

	public void setGrafoId(int grafoId) {
		this.grafoId = grafoId;
	}

	public String getNomeMapa() {
		return nomeMapa;
	}

	public void setNomeMapa(String nomeMapa) {
		this.nomeMapa = nomeMapa;
	}

	public List<Vertice> getVerticets() {
		return verticets;
	}

	public void setVerticets(List<Vertice> verticets) {
		this.verticets = verticets;
	}
	
}
