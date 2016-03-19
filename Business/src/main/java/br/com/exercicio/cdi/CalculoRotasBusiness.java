package br.com.exercicio.cdi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import javax.inject.Inject;

import br.com.exercicio.comparators.VerticeComparator;
import br.com.exercicio.dto.EntradaCalculo;
import br.com.exercicio.dto.MapaMalha;
import br.com.exercicio.dto.RotaMalha;
import br.com.exercicio.entities.Aresta;
import br.com.exercicio.entities.Grafo;
import br.com.exercicio.entities.Vertice;
import br.com.exercicio.exception.GrafoExcpetion;

public class CalculoRotasBusiness {

	/**
	 * Atributo utils do tipo GrafoBusinessUtils
	 */
	@Inject
	GrafoBusinessUtils utils;

	/**
	 * Atributo dados do tipo GrafoDAO
	 */
	@Inject
	GrafoDAO dados;

	/**
	 * Método business que possui as regras de negocio para salvar o grafo
	 * @param malha
	 * @throws GrafoExcpetion
	 */
	public void gravaGrafo(MapaMalha malha) throws GrafoExcpetion {
		Grafo grafo = new Grafo();

		grafo.setNomeMapa(malha.getNomeMapa());
		
		if(dados.buscaGrafo(malha.getNomeMapa()) != null){
			throw new GrafoExcpetion("Mapa já cadastrado");
		}
		
		// TODO verifica existencia do grafo na base
		// Metodo percorre a malha e monta o objeto do grafo que sera
		// persistido na base
		for (RotaMalha rota : malha.getRotas()) {

			// nao aceita distancia negativa e nem cordenadas vazias.
			if (rota.getDistancia() < 0 || rota.getP1().trim().equals("") || rota.getP2().trim().equals("")) {
				throw new GrafoExcpetion("Mapa inválido");
			}

			Aresta ar = new Aresta();
			ar.setDestino(rota.getP2().toUpperCase().trim());
			ar.setDistancia(rota.getDistancia());

			Vertice vertice = utils.buscaVertice(rota.getP1().toUpperCase().trim(), grafo.getVerticets());

			if (vertice == null) {
				vertice = utils.criaVertice(rota.getP1().toUpperCase().trim());
				grafo.getVerticets().add(vertice);
				vertice.setGrafo(grafo);
			}
			ar.setVertice(vertice);
			vertice.getArestats().add(ar);
			
			vertice = utils.buscaVertice(rota.getP2().toUpperCase().trim(), grafo.getVerticets());

			if (vertice == null) {
				vertice = new Vertice();
				vertice = utils.criaVertice(rota.getP2().toUpperCase().trim());
				vertice.getArestats().add(ar);
				grafo.getVerticets().add(vertice);
				vertice.setGrafo(grafo);
			}
		}
		try {
			// persiste grafo montado
			dados.add(grafo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Método que possui as regras de negocio para buscar uma rota
	 * @param entrada
	 * @return
	 * @throws IOException
	 * @throws GrafoExcpetion
	 */
	public String calculaRota(EntradaCalculo entrada) throws IOException, GrafoExcpetion {
		double custo = 0d;
		Grafo grafo = new Grafo();
		String resposta = null;

		grafo.setNomeMapa(entrada.getNomeMapa().toUpperCase().trim());
		grafo = dados.buscaGrafo(grafo.getNomeMapa());
		// verifica se existe o grafo na base
		if (grafo != null) {
			if (entrada.getVertice1().equals("") || entrada.getAutonomia() <= 0 || entrada.getValorLitro() <= 0
					|| entrada.getVertice2().equals("")) {
				throw new GrafoExcpetion("Dados de entrada inválidos");
			}
			List<Vertice> verticets = grafo.getVerticets();

			// busca vertice da origem da rota
			Vertice vert = buscaVertice(entrada.getVertice1(), verticets);
			Vertice vertDestino = buscaVertice(entrada.getVertice2(), verticets);
			// Verifica se origem existe
			if (vert == null) {
				throw new GrafoExcpetion("vertice origem não existe");
			}
			// Verifica se destino existe
			if (vertDestino == null) {
				throw new GrafoExcpetion("vertice destino não existe");
			}

			// gera caminhos utilizando o algoritmo de DIJKSTRA
			geraCaminhos(vert, verticets);
			
			// verifica a lista procurando a rota com o destino desejado
			for (Vertice v : verticets) {
				if (v.getNomeVertice().endsWith(entrada.getVertice2().toUpperCase().trim())) {

					if (v.getDistMinima() == Double.POSITIVE_INFINITY) {
						throw new GrafoExcpetion("não existe rota");
					}

					custo = v.getDistMinima() / entrada.getAutonomia() * entrada.getValorLitro();
					resposta = "".concat("Distancia para ").concat(v.getNomeVertice()).concat(": ")
							.concat(new Double(v.getDistMinima()).toString());
					resposta = resposta.concat(" Caminho:");
					List<Vertice> path = pegaMenorCaminho(v);

					// concatena a rota
					for (Vertice u : path) {
						resposta = resposta.concat("->").concat(u.getNomeVertice());
					}
					// gera o custo
					resposta = resposta.concat(" Custo de ").concat(new Double(custo).toString());
				}
			}
			
			
		} else {
			throw new GrafoExcpetion("mapa não existe");
		}
		return resposta;
	}
	
	
	/**
	 * Método que após a execução do algoritmo de DIJKSTRA inverte a coleção
	 * para pegar os caminhos do início para o fim
	 * 
	 * @author Cristiano Momesso
	 * @param target
	 * @return
	 */
	private static List<Vertice> pegaMenorCaminho(Vertice target) {
		List<Vertice> path = new ArrayList<Vertice>();

		for (Vertice vertice = target; vertice != null; vertice = vertice
				.getAnterior()) {
			path.add(vertice);
		}
		Collections.reverse(path);
		return path;
	}
	/**
	 * Método que implementa o algoritmo de DIJKSTRA
	 * 
	 * @author Cristiano Momesso
	 * @param vert
	 * @param verticets
	 */
	private void geraCaminhos(Vertice vert, List<Vertice> verticets) {
		vert.setDistMinima(0.);
		Comparator<Vertice> comparator = new VerticeComparator();
		PriorityQueue<Vertice> vertexQueue = new PriorityQueue<Vertice>(comparator);
		// coloca vertice incial como prioridade
		vertexQueue.add(vert);
		while (!vertexQueue.isEmpty()) {
			Vertice u = vertexQueue.poll();
			// verifica arestas
			for (Aresta e : u.getArestats()) {
				// busca vertice da aresta
				Vertice v = buscaVertice(e.getDestino(), verticets);
				double distancia = e.getDistancia();
				double distanceAteU = u.getDistMinima() + distancia;
				// aplica regra da distancia
				if (distanceAteU < v.getDistMinima()) {
					vertexQueue.remove(v);
					v.setDistMinima(distanceAteU);
					v.setAnterior(u);
					vertexQueue.add(v);
				}
			}
		}
	}
	
	/**
	 * Método que busca vertice de destino em uma lista
	 * 
	 * @author Cristiano Momesso
	 * @param destino
	 * @param verticets
	 * @return
	 */
	private  Vertice buscaVertice(String destino,
			List<Vertice> verticets) {
		for (Vertice e : verticets) {
			if (e.getNomeVertice().toUpperCase().equals(destino.toUpperCase())) {
				return e;
			}
		}
		return null;
	}

}
