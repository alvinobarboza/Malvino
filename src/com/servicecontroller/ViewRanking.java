package com.servicecontroller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;

import com.dao.HibernateDAO;

public class ViewRanking extends HibernateDAO<T>{
	
	
	public ViewRanking() {
		super(T.class);
	}
	
	public List<RankingTemp> rankingPorJogo(String jogo) throws SQLException{
		
		int i = 0;
		List<RankingTemp> retorno = new ArrayList<RankingTemp>();
		
		String sql = "select h.ds_nome as Jogo,j.ds_nome as Jogador, r.nu_qtd_pontos_recorde as Recorde "
				+ "from malvino.jogadores_jogos r "
				+ "inner join malvino.jogadores j on r.pfk_jogador = j.id_jogador "
				+ "inner join malvino.jogos h on r.pfk_jogo = h.id_jogo "
				+ "where h.ds_nome = ? "
				+ "order by r.nu_qtd_pontos_recorde desc";
		
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, jogo);
		
		
		ResultSet rs = ps.executeQuery() ;
		
		while(rs.next()){
			
			RankingTemp ranking = new RankingTemp();
			
			ranking.setJogo(rs.getString("jogo"));
			ranking.setNome(rs.getString("jogador"));
			ranking.setPontos(rs.getInt("recorde"));
			
			retorno.add(ranking);
			System.out.println(ranking.getPontos());
			i++;
		}
		
		
		return retorno;
	}
}
