package com.service;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.JogosDAO;
import com.model.Jogos;
import com.servicecontroller.RankingTemp;
import com.servicecontroller.SalvarScore;
import com.servicecontroller.ViewRanking;



@Path("/ScoreGame") 
public class JogosService {
	
	private SalvarScore score;
	private Jogos jogos;
	private JogosDAO jogosDAO;
	private ViewRanking viewRanking;

	private int id;
	private int ponto;
	
	private static int coeficiente = 1;
	

	
	
	public ViewRanking getViewRanking() {
		if(viewRanking == null)
			viewRanking = new ViewRanking();
		return viewRanking;
	}


	public void setViewRanking(ViewRanking viewRanking) {
		this.viewRanking = viewRanking;
	}


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
	@Path("/RankingGlobal/{jogo}") 
	@Produces(MediaType.APPLICATION_JSON)
	public RankingTemp[] getRankingGlobal(@PathParam("jogo") String jogo) throws SQLException {
	//public void getRankingGlobal(@PathParam("jogo") String jogo) throws SQLException {
	
		List<RankingTemp> global = getViewRanking().rankingPorJogo(jogo);

		RankingTemp[] dtoList = new RankingTemp[global.size()];

		int i = 0;

		for (RankingTemp item : global){			
					
			dtoList[i] = item;
			
			i++;
		}

		System.out.println(jogo);
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
	@Path("/JogoVelhaVitoria/{i}")
	public void vVitoria(@PathParam("i") String Id) throws SQLException {
		
		this.id = Integer.parseInt(Id);
		
		this.ponto = 50*coeficiente;
		
		coeficiente = coeficiente+coeficiente;
		
		getScore().salvarPontos(id, ponto, "Jogo da Velha");
		System.out.println("id: "+id+" pontos "+ponto);
	}
	
	@GET
	@Path("/JogoVelhaEmpate/{i}")
	public void vEmpate(@PathParam("i") String Id) throws SQLException {
		
		this.id = Integer.parseInt(Id);
		
		this.ponto = 10;
		
		getScore().salvarPontos(id, ponto, "Jogo da Velha");
		
		System.out.println("id: "+id+" pontos "+ponto);
		coeficiente=1;
	}
	
	@GET
	@Path("/JogoVelhaDerrota/{i}")
	public void vDerrota(@PathParam("i") String Id) {
		System.out.println(coeficiente);
		coeficiente=1;
	}


}
