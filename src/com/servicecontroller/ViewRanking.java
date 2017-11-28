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
	
	public List<RankingTemp> rankingGlobal() throws SQLException{
		
		List<RankingTemp> retorno = new ArrayList<RankingTemp>();
		
		String sql = "select sum(r.nu_pontos) as Recorde, j.ds_nome as Jogador "
				+"from malvino.jogadores_jogos r "
				+"inner join malvino.jogadores j on r.pfk_jogador = j.id_jogador "
				+"group by j.ds_nome "
                +"order by sum(r.nu_pontos) desc";
		
		
		PreparedStatement ps = getConnection().prepareStatement(sql);		
		ResultSet rs = ps.executeQuery() ;
		
		while(rs.next()){
			
			RankingTemp ranking = new RankingTemp();
			
			ranking.setNome(rs.getString("jogador"));
			ranking.setPontos(rs.getInt("recorde"));
			
			retorno.add(ranking);
			System.out.println(ranking.getPontos());
		}
		
		
		return retorno;
	}
}
