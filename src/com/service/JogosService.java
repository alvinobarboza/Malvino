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



@Path("/ScoreGame") 
public class JogosService {
	
	String num;
		
	/*@GET 
	@Path("/Jogadores") 
	@Produces(MediaType.APPLICATION_JSON)
	public Jogadores[] getJogadores() {
	
		return dtoList;
		
	}*/
	
	@GET
	@Path("/contador/{i}")
	public void autenticar(@PathParam("i") String logar) {
				
		
		System.out.println(logar);
	
	}
}
