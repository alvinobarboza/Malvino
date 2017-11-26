package com.servicecontroller;

import java.util.List;

import com.dao.JogadoresDAO;
import com.model.Jogadores;

public class JogadoresController {
	
	JogadoresDAO dao;
	Jogadores temp;
	LogarController verifica;
	
	public JogadoresDAO getDao() {
		if(dao == null)
			dao = new JogadoresDAO();
		return dao;
	}
	public void setDao(JogadoresDAO dao) {
		this.dao = dao;
	}
	public Jogadores getTemp() {
		if(temp == null)
			temp = new Jogadores();
		return temp;
	}
	public void setTemp(Jogadores temp) {
		this.temp = temp;
	}
	
	public LogarController verificaDuplicado(Jogadores jogadores){
		
		LogarController resultado = new LogarController();
		
		List<Jogadores> list = getDao().getBeansByExample(jogadores);
		
		for(Jogadores jogador:list){
			if(jogador.getLogin().equals(jogadores.getLogin())){
				resultado.setLogin("Em uso, informe outro!");
			}else{
				resultado.setLogin("ok");
			}
			if(jogador.getEmail().equals(jogadores.getEmail())){
				resultado.setSenha("Já cadastrado, informe outro!");
			}else{
				resultado.setSenha("ok");
			}
		}
		
		
		return resultado;
	}
	
	public Jogadores cloneToDTO(Jogadores bruto){
		
		Jogadores jogador = new Jogadores();
		
		if(bruto==null){
			jogador.setNome("Não Existe");
		}else{
		jogador.getClas().setDescricao(bruto.getClas().getDescricao());
		jogador.getClas().setNome(bruto.getClas().getNome());
		jogador.getClas().setQtdMenbros(bruto.getClas().getQtdMenbros());
		jogador.getClas().setIdCla(bruto.getClas().getIdCla());
		
		jogador.getPerfis().setDescricao(bruto.getPerfis().getDescricao());
		jogador.getPerfis().setNome(bruto.getPerfis().getNome());
		jogador.getPerfis().setIdPerfil(bruto.getPerfis().getIdPerfil());
		
		jogador.setEmail(bruto.getEmail());
		jogador.setNome(bruto.getNome());
		jogador.setGenero(bruto.getGenero());
		jogador.setLogin(bruto.getLogin());
		jogador.setSenha(bruto.getSenha());
		jogador.setIdJogador(bruto.getIdJogador());
		}
		return jogador;
	}
	
	
}
