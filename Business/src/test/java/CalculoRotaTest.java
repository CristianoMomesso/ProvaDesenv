import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.exercicio.cdi.CalculoRotasBusiness;
import br.com.exercicio.cdi.GrafoDAO;
import br.com.exercicio.dto.MapaMalha;
import br.com.exercicio.entities.Grafo;
import br.com.exercicio.exception.GrafoExcpetion;

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
	 * Atributo calc do tipo CalculoRotasBusiness
	 */
	@InjectMocks
	CalculoRotasBusiness calc;
	
	/**Método que testa se um mapa existe
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
}
