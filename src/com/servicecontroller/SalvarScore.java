package com.servicecontroller;

import java.sql.SQLException;

import com.dao.JogadoresDAO;
import com.dao.JogadoresJogosDAO;
import com.dao.JogosDAO;
import com.model.Jogadores;
import com.model.JogadoresJogos;
import com.model.Jogos;

public class SalvarScore {
	
	private JogadoresDAO jogadoresDAO;
	private JogosDAO jogosDAO;
	private JogadoresJogosDAO jogadoresJogosDAO;
	
	private Jogadores jogadores;
	private Jogos jogos;
	private JogadoresJogos jogadoresJogos;
	
	
	
	
	public JogadoresDAO getJogadoresDAO() {
		if(jogadoresDAO == null)
			jogadoresDAO = new JogadoresDAO();
		return jogadoresDAO;
	}

	public void setJogadoresDAO(JogadoresDAO jogadoresDAO) {
		this.jogadoresDAO = jogadoresDAO;
	}

	public JogosDAO getJogosDAO() {
		if(jogosDAO == null)
			jogosDAO = new JogosDAO();
		return jogosDAO;
	}

	public void setJogosDAO(JogosDAO jogosDAO) {
		this.jogosDAO = jogosDAO;
	}

	public JogadoresJogosDAO getJogadoresJogosDAO() {
		if(jogadoresJogosDAO == null)
			jogadoresJogosDAO = new JogadoresJogosDAO();
		return jogadoresJogosDAO;
	}

	public void setJogadoresJogosDAO(JogadoresJogosDAO jogadoresJogosDAO) {
		this.jogadoresJogosDAO = jogadoresJogosDAO;
	}

	public Jogadores getJogadores() {
		if(jogadores == null)
			jogadores = new Jogadores();
		return jogadores;
	}

	public void setJogadores(Jogadores jogadores) {
		this.jogadores = jogadores;
	}

	public Jogos getJogos() {
		if(jogos == null)
			jogos = new Jogos();
		return jogos;
	}

	public void setJogos(Jogos jogos) {
		this.jogos = jogos;
	}

	public JogadoresJogos getJogadoresJogos() {
		if(jogadoresJogos == null)
			jogadoresJogos = new JogadoresJogos();
		return jogadoresJogos;
	}

	public void setJogadoresJogos(JogadoresJogos jogadoresJogos) {
		this.jogadoresJogos = jogadoresJogos;
	}

	
	public void salvarPontos(int id, int score, String jogo) throws SQLException{
		
		setJogadores(getJogadoresDAO().getBean(id));
		
		setJogos(getJogosDAO().getBeanByName(jogo));
		
		getJogadoresJogos().setJogador(getJogadores());
		getJogadoresJogos().setJogo(getJogos());
		
		
		setJogadoresJogos(getJogadoresJogosDAO().getBeanByExample(getJogadoresJogos()));	
	
		if (getJogadoresJogos().getJogador().getNome()==null) {
			
			getJogadoresJogos().setJogador(getJogadores());
			getJogadoresJogos().setJogo(getJogos());
			getJogadoresJogos().setJogador(getJogadores());
			getJogadoresJogos().setPontosRecorde(score);
			getJogadoresJogos().setPontosTotais(score);
			getJogadoresJogos().setTempoJogo("00:00:00");
			getJogadoresJogos().setTempoRecorde("00:00:00");
			
			getJogadoresJogosDAO().salvar(getJogadoresJogos());
			getJogadoresJogosDAO().commit();
			
			
		} else {
			
			getJogadoresJogos().setPontosRecorde(score);
			getJogadoresJogos().setPontosTotais(score);
			getJogadoresJogos().setTempoJogo("00:00:00");
			getJogadoresJogos().setTempoRecorde("00:00:00");
			
			getJogadoresJogosDAO().atualizar(getJogadoresJogos());
			getJogadoresJogosDAO().commit();
		}
		
		System.out.println(getJogadoresJogos().getJogador().getNome()+"---"+getJogadoresJogos().getJogo().getNome()
				+" pontuação: "+getJogadoresJogos().getPontosRecorde());
		
	}
	
	public Jogos cloneToDTO(Jogos bruto){
		
		Jogos jogo = new Jogos();
		
		if(bruto==null){
			jogo.setNome("Não Existe");
		}else{
		jogo.setIdJogo(bruto.getIdJogo());
		jogo.setDescricao(bruto.getDescricao());
		jogo.setNome(bruto.getNome());
		jogo.setAtivo(bruto.isAtivo());
		}
		return jogo;
	}

}
