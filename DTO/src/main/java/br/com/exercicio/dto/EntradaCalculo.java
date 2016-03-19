package br.com.exercicio.dto;

/**
 * DTO referene a entrada do calculo
 * @author Cristiano Momesso
 *
 */
public class EntradaCalculo {

	/**
	 * Atributo nomeMapa do tipo String
	 */
	private String nomeMapa;
	/**
	 * Atributo vertice1 do tipo String
	 */
	private String vertice1;
	/**
	 * Atributo vertice2 do tipo String
	 */
	private String vertice2;
	/**
	 * Atributo autonomia do tipo double
	 */
	private double autonomia;
	/**
	 * Atributo valorLitro do tipo double
	 */
	private double valorLitro;
	
	/**
	 * @return
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
	 * @return
	 */
	public String getVertice1() {
		return vertice1;
	}
	/**
	 * @param vertice1
	 */
	public void setVertice1(String vertice1) {
		this.vertice1 = vertice1;
	}
	/**
	 * @return
	 */
	public String getVertice2() {
		return vertice2;
	}
	/**
	 * @param vertice2
	 */
	public void setVertice2(String vertice2) {
		this.vertice2 = vertice2;
	}
	/**
	 * @return
	 */
	public double getAutonomia() {
		return autonomia;
	}
	/**
	 * @param autonomia
	 */
	public void setAutonomia(double autonomia) {
		this.autonomia = autonomia;
	}
	/**
	 * @return
	 */
	public double getValorLitro() {
		return valorLitro;
	}
	/**
	 * @param valorLitro
	 */
	public void setValorLitro(double valorLitro) {
		this.valorLitro = valorLitro;
	}
}
