package com.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;



@Path("/ScoreGame") 
public class JogosService {
	
	private int id;
	@SuppressWarnings("unused")
	private int ponto;
	
	@GET
	@Path("/T-rex/{i}/{x}")
	public void trex(@PathParam("i") String id,@PathParam("x") String x) {
		
		this.id = Integer.parseInt(id);
		this.ponto = Integer.parseInt(x);
		
		System.out.println("high score T-rex: "+this.id+" ID: "+x);
	}
	
	@GET
	@Path("/JogoVelhaDerrota/{i}/{x}")
	public void vDerrota(@PathParam("i") String id, @PathParam("x") String x) {
		
		this.id = Integer.parseInt(id);
		this.ponto = Integer.parseInt(x);		
		
		System.out.println("Derrotas: "+id+" ID: "+x);
	
	}
	
	@GET
	@Path("/JogoVelhaVitoria/{i}/{x}")
	public void vVitoria(@PathParam("i") String id, @PathParam("x") String x) {
		
		this.id = Integer.parseInt(id);
		this.ponto = Integer.parseInt(x);		
		
		System.out.println("Vitórias: "+id+" ID: "+x);
	
	}
	
	@GET
	@Path("/JogoVelhaEmpate/{i}/{x}")
	public void vEmpate(@PathParam("i") String id, @PathParam("x") String x) {
		
		this.id = Integer.parseInt(id);
		this.ponto = Integer.parseInt(x);		
		
		System.out.println("Empates: "+id+" ID: "+x);
	
	}
}
