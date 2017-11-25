package com.service;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.JogosDAO;
import com.model.Jogadores;
import com.model.Jogos;
import com.servicecontroller.SalvarScore;



@Path("/ScoreGame") 
public class JogosService {
	
	private SalvarScore score;
	private Jogos jogos;
	private JogosDAO jogosDAO;
	
	
	
	
	public SalvarScore getScore() {
		if(score == null)
			score = new SalvarScore();
		return score;
	}


	public void setScore(SalvarScore score) {
		this.score = score;
	}


	public JogosDAO getJogosDAO() {
		if(jogosDAO == null)
			jogosDAO = new JogosDAO();
		return jogosDAO;
	}


	public void setJogosDAO(JogosDAO jogosDAO) {
		this.jogosDAO = jogosDAO;
	}

	public Jogos getJogos() {
		if(jogos == null)
			jogos = new Jogos();
		return jogos;
	}
	
	public void setJogos(Jogos jogos) {
		this.jogos = jogos;
	}

	private int id;
	@SuppressWarnings("unused")
	private int ponto;
	
	@GET 
	@Path("/allGames") 
	@Produces(MediaType.APPLICATION_JSON)
	public Jogos[] getGames() {
	
		List<Jogos> jogos = getJogosDAO().getBeans();

		Jogos[] dtoList = new Jogos[jogos.size()];

		int i = 0;

		for (Jogos item : jogos){			
					
			dtoList[i] = getScore().cloneToDTO(item);
			
			i++;
		}

		return dtoList;
		
	}
	


	@GET
	@Path("/T-rex/{i}/{x}")
	public void trex(@PathParam("i") String Id,@PathParam("x") String x) throws SQLException {
		
		this.id = Integer.parseInt(Id);
		this.ponto = Integer.parseInt(x);
		
		getScore().salvarPontos(id, ponto, "T-Rex");
		
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
