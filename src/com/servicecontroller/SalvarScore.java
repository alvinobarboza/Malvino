package com.servicecontroller;

import java.sql.SQLException;

import com.dao.ClasDAO;
import com.dao.JogadoresDAO;
import com.dao.JogadoresJogosDAO;
import com.dao.JogosDAO;
import com.model.Clas;
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
	
	private Clas clas;
	private ClasDAO clasDAO;
	
	
	public Clas getClas() {
		if(clas == null)
			clas = new Clas();
		return clas;
	}

	public void setClas(Clas clas) {
		this.clas = clas;
	}

	public ClasDAO getClasDAO() {
		if(clasDAO == null)
			clasDAO = new ClasDAO();
		return clasDAO;
	}

	public void setClasDAO(ClasDAO clasDAO) {
		this.clasDAO = clasDAO;
	}

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
			
			
			getJogadoresJogosDAO().salvar(getJogadoresJogos());
			getJogadoresJogosDAO().commit();
			
			System.out.println("Nome: "+getJogadoresJogos().getJogador().getNome()+"\n"+
					"Pontuação: "+getJogadoresJogos().getPontosTotais()+"\n"+
					"Jogo: "+getJogadoresJogos().getJogo().getNome()+"\n"+
					"Cla: "+getJogadoresJogos().getCla().getNome());
			
		} else {
			
			getJogadoresJogos().setPontosRecorde(score);
			getJogadoresJogos().setPontosTotais(score);
			
			System.out.println("Nome: "+getJogadoresJogos().getJogador().getNome()+"\n"+
								"Pontuação: "+getJogadoresJogos().getPontosTotais()+"\n"+
								"Jogo: "+getJogadoresJogos().getJogo().getNome()+"\n"+
								"Cla: "+getJogadoresJogos().getCla().getNome());
			
			getJogadoresJogosDAO().atualizar(getJogadoresJogos());
			getJogadoresJogosDAO().commit();
		}
		
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
