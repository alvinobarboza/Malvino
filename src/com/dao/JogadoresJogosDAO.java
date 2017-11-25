
package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Jogadores;
import com.model.JogadoresJogos;
import com.model.Jogos;

public class JogadoresJogosDAO extends HibernateDAO<JogadoresJogos>{
	public JogadoresJogosDAO()
	{
		super(JogadoresJogos.class);
	}

	public JogadoresJogos getBeanByExample(JogadoresJogos jogadoresJogos) throws SQLException {
		
		JogadoresJogos retorno = new JogadoresJogos();
		Jogos jogo = new Jogos();
		JogosDAO jogoDAO = new JogosDAO();

		Jogadores jogador = new Jogadores();
		JogadoresDAO jogadorDAO = new JogadoresDAO();
		
		
		String sql = "select * from malvino.jogadores_jogos j "
				+ "where j.pfk_jogador = ? and j.pfk_jogo = ?";
		
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setInt(1, jogadoresJogos.getJogador().getIdJogador());
		ps.setInt(2, jogadoresJogos.getJogo().getIdJogo());
		
		
		
		
		ResultSet rs = ps.executeQuery() ;
		
		if (rs!=null) {
			jogo = jogoDAO.getBean(jogadoresJogos.getJogo().getIdJogo());
			jogador = jogadorDAO.getBean(jogadoresJogos.getJogador().getIdJogador());
			
			while(rs.next()){
				
				retorno.setJogo(jogo);
				retorno.setJogador(jogador);
				retorno.setPontosRecorde(rs.getInt("nu_qtd_pontos_recorde"));
				retorno.setTempoRecorde(rs.getString("nu_tempo_recorde"));
				retorno.setTempoJogo(rs.getString("nu_tempo_jogo"));
				retorno.setPontosTotais(rs.getInt("nu_pontos"));
								
			}
			
		} else {

		}
		
		return retorno;
	}
	
	
}
