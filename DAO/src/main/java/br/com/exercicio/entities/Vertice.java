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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Vertice {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int verticeId;

	private String nomeVertice;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "vertice",  targetEntity = Aresta.class,fetch = FetchType.EAGER)
	private List<Aresta> arestats= new ArrayList<Aresta>();
	
	@ManyToOne
	@JoinColumn(name="grafoId")
	Grafo grafo;
	
	@Transient  
	private  double distMinima = Double.POSITIVE_INFINITY;
	
	@Transient  
	private Vertice anterior;

	public int getVerticeId() {
		return verticeId;
	}

	public void setVerticeId(int verticeId) {
		this.verticeId = verticeId;
	}

	public String getNomeVertice() {
		return nomeVertice;
	}

	public void setNomeVertice(String nomeVertice) {
		this.nomeVertice = nomeVertice;
	}

	public List<Aresta> getArestats() {
		return arestats;
	}

	public void setArestats(List<Aresta> arestats) {
		this.arestats = arestats;
	}

	public double getDistMinima() {
		return distMinima;
	}

	public void setDistMinima(double distMinima) {
		this.distMinima = distMinima;
	}

	public Vertice getAnterior() {
		return anterior;
	}

	public void setAnterior(Vertice anterior) {
		this.anterior = anterior;
	}

	public Grafo getGrafo() {
		return grafo;
	}

	public void setGrafo(Grafo grafo) {
		this.grafo = grafo;
	}	
	
}
