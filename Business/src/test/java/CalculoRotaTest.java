import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.exercicio.cdi.CalculoRotasBusiness;
import br.com.exercicio.cdi.GrafoDAO;

@RunWith(MockitoJUnitRunner.class)
public class CalculoRotaTest {

	@Mock
	GrafoDAO dados;
	
	 @InjectMocks
	 CalculoRotasBusiness calc;
	 
	  @Test
	    public void testDoIt() {
		  System.out.println("ok");
	    }
}
