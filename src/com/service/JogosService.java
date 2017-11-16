package com.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;



@Path("/ScoreGame") 
public class JogosService {
	
	@GET
	@Path("/T-rex/{i}")
	public void trex(@PathParam("i") String logar) {
				
		
		System.out.println("high score T-rex: "+logar);
	
	}
	@GET
	@Path("/JogoVelhaDerrota/{i}")
	public void vDerrota(@PathParam("i") String logar) {
				
		
		System.out.println("Derrotas: "+logar);
	
	}
	@GET
	@Path("/JogoVelhaVitoria/{i}")
	public void vVitoria(@PathParam("i") String logar) {
				
		
		System.out.println("Vitorias: "+logar);
	
	}
	@GET
	@Path("/JogoVelhaEmpate/{i}")
	public void vEmpate(@PathParam("i") String logar) {
				
		
		System.out.println("Empates: "+logar);
	
	}
}
