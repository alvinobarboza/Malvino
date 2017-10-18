package com.bean;

import java.util.List;

import com.dao.JogadoresJogosDAO;

import com.model.JogadoresJogos;


public class MainTeste {
	public static void main(String [] args) {
		
		//JogadoresJogos teste = new JogadoresJogos();
		JogadoresJogosDAO dao = new JogadoresJogosDAO();
		
		List<JogadoresJogos> teste = dao.getBeans();
		
		
		for(JogadoresJogos t : teste){
		System.out.println("O jogador "+t.getJogador().getNome()+" jogou "+t.getJogo().getNome()+
				"\n e fez um recorde de "+t.getPontosRecorde()+" pontos");
		}
	}
}
