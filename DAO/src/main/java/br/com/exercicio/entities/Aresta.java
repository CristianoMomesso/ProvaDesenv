package br.com.exercicio.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Aresta {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int arestaId;
	
	private String destino;

	private double distancia;

	@ManyToOne
	@JoinColumn(name="verticeId")
	Vertice vertice;

	


	public Vertice getVertice() {
		return vertice;
	}

	public void setVertice(Vertice vertice) {
		this.vertice = vertice;
	}

	public int getArestaId() {
		return arestaId;
	}

	public void setArestaId(int arestaId) {
		this.arestaId = arestaId;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
}
