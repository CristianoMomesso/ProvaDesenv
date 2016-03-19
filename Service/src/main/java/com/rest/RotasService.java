package com.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.exercicio.cdi.CalculoRotasBusiness;
import br.com.exercicio.dto.EntradaCalculo;
import br.com.exercicio.dto.MapaMalha;
import br.com.exercicio.exception.GrafoExcpetion;

@Path("/Rotas")
public class RotasService {

	/**
	 * Atributo calc do tipo CalculoRotasBusiness
	 */
	@Inject
	CalculoRotasBusiness calc;

	/**
	 * Método web para persistência de mapa na base
	 * 
	 * @param json
	 * @return json
	 */
	@POST
	@Path("/gravaMapa")
	@Consumes("application/json")
	@Produces("application/json")
	public Response gravaMapa(MapaMalha json) throws Exception {
		try {
			calc.gravaGrafo(json);
			return Response.status(200).entity("Mapa salvo com sucesso!!").build();
		} catch (GrafoExcpetion e) {
			return Response.status(200).entity(e.getMessage()).build();
		}
		catch (Exception e) {
			throw e;// new ExceptionMapperImpl();
		}
	}
	
	/**
	 * Método web para calculo da rota
	 * @param json
	 * @return json
	 */
	@POST
	@Path("/pesquisaRota")
	@Consumes("application/json")
	@Produces("application/json")
	public Response calcularRota(EntradaCalculo json) {
		try {
			String resp= calc.calculaRota(json);
			return Response.status(200).entity(resp).build();
		}  catch (Exception e) {
			return Response.status(200).entity(e.getMessage()).build();
		}
	}
}
