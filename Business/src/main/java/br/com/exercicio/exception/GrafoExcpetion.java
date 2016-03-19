package br.com.exercicio.exception;

/**
 * Exception específica  
 * @author Cristiano Momesso
 *
 */
public class GrafoExcpetion extends Exception {

	/**
	 * Atributo serialVersionUID do tipo long
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor Exception
	 * @param msg
	 */
	public GrafoExcpetion(String msg) {
		super(msg);
	}
}
