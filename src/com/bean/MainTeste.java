package com.bean;

import java.sql.SQLException;
import java.util.List;

import com.dao.JogadoresDAO;
import com.dao.JogadoresJogosDAO;
import com.dao.JogosDAO;
import com.model.Jogadores;
import com.model.JogadoresJogos;
import com.model.Jogos;
import com.servicecontroller.RankingTemp;
import com.servicecontroller.ViewRanking;

public class MainTeste {
	
	
	public static void main(String [] args) throws SQLException {
		ViewRanking ranking = new ViewRanking();
		
		List<RankingTemp> teste = ranking.rankingPorJogo("Jogo da Velha");
		
		for(RankingTemp item : teste){
			System.out.println(item.getPontos());
		}
		

			
	}
}
