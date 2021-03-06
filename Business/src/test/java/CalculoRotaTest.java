import static org.mockito.Matchers.any;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.exercicio.cdi.GrafoDAO;
import br.com.exercicio.dto.EntradaCalculo;
import br.com.exercicio.dto.MapaMalha;
import br.com.exercicio.dto.RotaMalha;
import br.com.exercicio.entities.Grafo;
import br.com.exercicio.entities.Vertice;
import br.com.exercicio.exception.GrafoExcpetion;
import br.com.exercicio.impl.CalculoRotasBusinessImpl;
import br.com.exercicio.impl.GrafoBusinessUtils;

/**
 * Classe referente aos testes do calculo de rota
 * @author Cristiano Momesso
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CalculoRotaTest {

	/**
	 * Atributo dados do tipo GrafoDAO
	 */
	@Mock
	GrafoDAO dados;
	
	/**
	 * Atributo utils do tipo GrafoBusinessUtils
	 */
	@Mock
	GrafoBusinessUtils utils;

	/**
	 * Atributo calc do tipo CalculoRotasBusiness
	 */
	@InjectMocks
	CalculoRotasBusinessImpl calc;
	
	/**M�todo que testa se um mapa existe
	 * @throws GrafoExcpetion
	 */
	@Test(expected = GrafoExcpetion.class) 
	public void mapaExistente() throws GrafoExcpetion {
		Mockito.when(this.dados.buscaGrafo("mapaExiste"))
				.thenReturn(new Grafo());	
		MapaMalha mapa = new MapaMalha();
		mapa.setNomeMapa("mapaExiste");
		calc.gravaGrafo(mapa);
	}
	
	/**M�todo que testa se um mapa possui rotas
	 * @throws GrafoExcpetion
	 */
	@Test(expected = GrafoExcpetion.class) 
	public void semRotas() throws GrafoExcpetion {
		Mockito.when(this.dados.buscaGrafo("teste"))
				.thenReturn(null);	
		MapaMalha mapa = new MapaMalha();
		mapa.setNomeMapa("teste");
		calc.gravaGrafo(mapa);
	}
	
	/**M�todo que testa se um mapa possui rotas
	 * @throws GrafoExcpetion
	 */
	@Test(expected = GrafoExcpetion.class) 
	public void rotasInvalidas() throws GrafoExcpetion {
		Mockito.when(this.dados.buscaGrafo("teste"))
				.thenReturn(null);	
		MapaMalha mapa = new MapaMalha();
		mapa.setNomeMapa("teste");
		List rotas = new ArrayList<RotaMalha>();
		mapa.setRotas(rotas); 
		calc.gravaGrafo(mapa);
	}
	
	/**M�todo que testa se um mapa possui rotas
	 * @throws GrafoExcpetion
	 */
	@Test(expected = GrafoExcpetion.class) 
	public void mapaInvalidas() throws GrafoExcpetion {
		Mockito.when(this.dados.buscaGrafo("teste"))
				.thenReturn(null);	
		MapaMalha mapa = new MapaMalha();
		mapa.setNomeMapa("teste");
		List rotas = new ArrayList<RotaMalha>();
		RotaMalha primeiraRota = new RotaMalha();
		primeiraRota.setDistancia(-10d);
		primeiraRota.setP1("A");
		primeiraRota.setP2("B");
		rotas.add(primeiraRota);
		mapa.setRotas(rotas); 
		calc.gravaGrafo(mapa);
	}
	
	/**M�todo que testa se um mapa possui rotas
	 * @throws GrafoExcpetion
	 */
	@Test(expected = GrafoExcpetion.class) 
	public void mapaInvalidasP1Nulo() throws GrafoExcpetion {
		Mockito.when(this.dados.buscaGrafo("teste"))
				.thenReturn(null);	
		MapaMalha mapa = new MapaMalha();
		mapa.setNomeMapa("teste");
		List rotas = new ArrayList<RotaMalha>();
		RotaMalha primeiraRota = new RotaMalha();
		primeiraRota.setDistancia(10d);
		primeiraRota.setP2("B");
		rotas.add(primeiraRota);
		mapa.setRotas(rotas); 
		calc.gravaGrafo(mapa);
	}
	
	/**M�todo que testa se um mapa possui rotas
	 * @throws GrafoExcpetion
	 */
	@Test(expected = GrafoExcpetion.class) 
	public void mapaInvalidasP1Vazio() throws GrafoExcpetion {
		Mockito.when(this.dados.buscaGrafo("teste"))
				.thenReturn(null);	
		MapaMalha mapa = new MapaMalha();
		mapa.setNomeMapa("teste");
		List rotas = new ArrayList<RotaMalha>();
		RotaMalha primeiraRota = new RotaMalha();
		primeiraRota.setDistancia(10d);
		primeiraRota.setP1("");
		primeiraRota.setP2("B");
		rotas.add(primeiraRota);
		mapa.setRotas(rotas); 
		calc.gravaGrafo(mapa);
	}
	
	/**M�todo que testa a cria��o da entidade a ser persistida no banco
	 * @throws GrafoExcpetion
	 */
	@Test
	public void mapaBuildEntitie() throws GrafoExcpetion {
		Mockito.when(this.dados.buscaGrafo("teste"))
				.thenReturn(null);
		Mockito.when(this.dados.add(any(Grafo.class)))
		.thenReturn(null);
		
		Vertice verticeA = new Vertice();
		verticeA.setNomeVertice("A");
		Mockito.when(utils.criaVertice("A"))
		.thenReturn(verticeA);
		
		Vertice verticeB = new Vertice();
		verticeB.setNomeVertice("B");
		Mockito.when(utils.criaVertice("B"))
		.thenReturn(verticeB);
		
		MapaMalha mapa = new MapaMalha();
		mapa.setNomeMapa("teste");
		List rotas = new ArrayList<RotaMalha>();
		RotaMalha primeiraRota = new RotaMalha();
		primeiraRota.setDistancia(10d);
		primeiraRota.setP1("A");
		primeiraRota.setP2("B");
		rotas.add(primeiraRota);
		mapa.setRotas(rotas); 
		calc.gravaGrafo(mapa);
	}
	
	/**
	 * @throws GrafoExcpetion
	 * @throws IOException 
	 */
	@Test(expected = GrafoExcpetion.class) 
	public void calculoRotaDadosInvalidos() throws GrafoExcpetion, IOException {
		Mockito.when(this.dados.buscaGrafo("teste"))
		.thenReturn(null);
		EntradaCalculo entrada = new EntradaCalculo();
		calc.calculaRota(entrada);
	}
	/**
	 * @throws GrafoExcpetion
	 * @throws IOException 
	 */
	@Test(expected = GrafoExcpetion.class) 
	public void calculoRotaAutonomiaZero() throws GrafoExcpetion, IOException {
		Mockito.when(this.dados.buscaGrafo("teste"))
		.thenReturn(null);
		EntradaCalculo entrada = new EntradaCalculo();
		entrada.setNomeMapa("Teste");
		entrada.setAutonomia(0);
		entrada.setVertice1("A");
		entrada.setVertice2("B");
		entrada.setValorLitro(10);
		calc.calculaRota(entrada);
	}
	
	/**
	 * @throws GrafoExcpetion
	 * @throws IOException 
	 */
	@Test(expected = GrafoExcpetion.class) 
	public void calculoRotaValorLitroZero() throws GrafoExcpetion, IOException {
		Mockito.when(this.dados.buscaGrafo("teste"))
		.thenReturn(null);
		EntradaCalculo entrada = new EntradaCalculo();
		entrada.setNomeMapa("Teste");
		entrada.setAutonomia(5);
		entrada.setVertice1("A");
		entrada.setVertice2("B");
		entrada.setValorLitro(0);
		calc.calculaRota(entrada);
	}
	
	/**
	 * @throws GrafoExcpetion
	 * @throws IOException 
	 */
	@Test(expected = GrafoExcpetion.class) 
	public void calculoRotaVerticeVazio() throws GrafoExcpetion, IOException {
		Mockito.when(this.dados.buscaGrafo("teste"))
		.thenReturn(null);
		EntradaCalculo entrada = new EntradaCalculo();
		entrada.setNomeMapa("Teste");
		entrada.setAutonomia(5);
		entrada.setVertice1("");
		entrada.setVertice2("B");
		entrada.setValorLitro(0);
		calc.calculaRota(entrada);
	}
}
