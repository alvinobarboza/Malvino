package com.bean;

import java.sql.SQLException;
import java.util.List;

import com.dao.JogadoresDAO;
import com.dao.JogadoresJogosDAO;
import com.dao.JogosDAO;
import com.model.Jogadores;
import com.model.JogadoresJogos;
import com.model.Jogos;

public class MainTeste {
	
	
	public static void main(String [] args) throws SQLException {
		JogadoresJogosDAO dao = new JogadoresJogosDAO();
		JogadoresJogos teste = new JogadoresJogos();
		
		JogadoresDAO jogadoresDAO = new JogadoresDAO();
		Jogadores jogadores = jogadoresDAO.getBean(1);
		
		JogosDAO jogosDAO = new JogosDAO();
		Jogos jogos = jogosDAO.getBean(1);
		
		teste.setJogador(jogadores);
		teste.setJogo(jogos);
		
		teste = dao.getBeanByExample(teste);
		
	
			System.out.println(teste.getTempoJogo());
	
			
	}
}
