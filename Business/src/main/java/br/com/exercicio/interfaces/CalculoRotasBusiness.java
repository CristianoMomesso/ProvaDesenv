package br.com.exercicio.interfaces;

import java.io.IOException;

import br.com.exercicio.dto.EntradaCalculo;
import br.com.exercicio.dto.MapaMalha;
import br.com.exercicio.exception.GrafoExcpetion;

public interface CalculoRotasBusiness {
	public void gravaGrafo(MapaMalha malha) throws GrafoExcpetion;
	public String calculaRota(EntradaCalculo entrada) throws IOException, GrafoExcpetion;
}
