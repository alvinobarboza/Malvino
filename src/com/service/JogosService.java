package com.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;



@Path("/ScoreGame") 
public class JogosService {
	
	@GET
	@Path("/T-rex/{i}/{x}")
	public void trex(@PathParam("i") String logar,@PathParam("x") String x) {
				
		
		System.out.println("high score T-rex: "+logar+" ID: "+x);
	
	}
	@GET
	@Path("/JogoVelhaDerrota/{i}/{x}")
	public void vDerrota(@PathParam("i") String logar, @PathParam("x") String x) {
				
		
		System.out.println("Derrotas: "+logar+" ID: "+x);
	
	}
	@GET
	@Path("/JogoVelhaVitoria/{i}/{x}")
	public void vVitoria(@PathParam("i") String logar, @PathParam("x") String x) {
				
		
		System.out.println("Vitórias: "+logar+" ID: "+x);
	
	}
	@GET
	@Path("/JogoVelhaEmpate/{i}/{x}")
	public void vEmpate(@PathParam("i") String logar, @PathParam("x") String x) {
				
		
		System.out.println("Empates: "+logar+" ID: "+x);
	
	}
}
