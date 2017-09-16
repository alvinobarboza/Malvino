package com.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.JogadoresDAO;
import com.model.Jogadores;
import com.model.Perfis;



@Path("/JogadoresService") 
public class JogadoresService {

	private JogadoresDAO jogadoresDAO;
	private Jogadores jogadores;
	private Perfis perfis;

	private JogadoresDAO getJogadoresDAO() {
		if (jogadoresDAO == null)
			jogadoresDAO = new JogadoresDAO();
		return jogadoresDAO;
	}

	private void setJogadoresDAO(JogadoresDAO jogadoresDAO) {
		this.jogadoresDAO = jogadoresDAO;
	}
	
	
	/**
	 * @return
	 */
	@GET 
	@Path("/Jogadores") 
	@Produces(MediaType.APPLICATION_JSON)
	public Jogadores[] Jogadores() {
	
		
		List<Jogadores> jogadores = getJogadoresDAO().getBeans();

		Jogadores[] dtoList = new Jogadores[jogadores.size()];

		int i = 0;

		for (Jogadores jogador : jogadores){			
			
			Jogadores dto = new Jogadores();
			
			dto.getClas().setDescricao(jogador.getClas().getDescricao());
			dto.getClas().setNome(jogador.getClas().getNome());
			dto.getClas().setQtdMenbros(jogador.getClas().getQtdMenbros());
			dto.getClas().setIdCla(jogador.getClas().getIdCla());
			
			dto.getPerfis().setDescricao(jogador.getPerfis().getDescricao());
			dto.getPerfis().setNome(jogador.getPerfis().getNome());
			dto.getPerfis().setIdPerfil(jogador.getPerfis().getIdPerfil());
			
			dto.setEmail(jogador.getEmail());
			dto.setNome(jogador.getNome());
			dto.setGenero(jogador.getGenero());
			dto.setLogin(jogador.getLogin());
			dto.setSenha(jogador.getSenha());
			dto.setIdJogador(jogador.getIdJogador());
			
			dtoList[i] = dto;
			
			i++;
		}

		return dtoList;
		

	}
	
	@GET 
	@Path("/Jogadores/{idJogador}") 
	@Produces(MediaType.APPLICATION_JSON)
	public Jogadores Jogadores(@PathParam("idJogador") int codigo) {

		Jogadores jogador = getJogadoresDAO().getBean(codigo);
		
		Jogadores dto = new Jogadores();
		
		dto.getClas().setDescricao(jogador.getClas().getDescricao());
		dto.getClas().setNome(jogador.getClas().getNome());
		dto.getClas().setQtdMenbros(jogador.getClas().getQtdMenbros());
		dto.getClas().setIdCla(jogador.getClas().getIdCla());
		
		dto.getPerfis().setDescricao(jogador.getPerfis().getDescricao());
		dto.getPerfis().setNome(jogador.getPerfis().getNome());
		dto.getPerfis().setIdPerfil(jogador.getPerfis().getIdPerfil());
		
		dto.setEmail(jogador.getEmail());
		dto.setNome(jogador.getNome());
		dto.setGenero(jogador.getGenero());
		dto.setLogin(jogador.getLogin());
		dto.setSenha(jogador.getSenha());
		dto.setIdJogador(jogador.getIdJogador());

		return dto;
		
	}

	public void salvar(Jogadores jogadores) {

		getJogadoresDAO().salvar(jogadores);
		getJogadoresDAO().commit();

	}

}
