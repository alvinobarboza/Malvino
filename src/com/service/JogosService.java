package com.service;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dao.JogadoresDAO;
import com.model.Jogadores;
import com.servicecontroller.JogadoresController;
import com.servicecontroller.Logar;



@Path("/JogosTeste") 
public class JogosService {
	
	String num;
		
	/*@GET 
	@Path("/Jogadores") 
	@Produces(MediaType.APPLICATION_JSON)
	public Jogadores[] getJogadores() {
	
		return dtoList;
		
	}*/
	
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
				
		
		System.out.println("Vitórias: "+logar);
	
	}
	@GET
	@Path("/JogoVelhaEmpate/{i}")
	public void vEmpate(@PathParam("i") String logar) {
				
		
		System.out.println("Empates: "+logar);
	
	}
}
