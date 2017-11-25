package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Jogos;;

public class JogosDAO extends HibernateDAO<Jogos> {

	public JogosDAO() {
		super(Jogos.class);
	}

	public Jogos getBeanByName(String jogo) throws SQLException {
		
		Jogos retorno = new Jogos();
		
		String sql = "select * from malvino.jogos j "
				+ "where j.ds_nome = ?";
		
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, jogo);
		
		
		ResultSet rs = ps.executeQuery() ;
		
		while(rs.next()){
	
			retorno.setNome(rs.getString("ds_nome"));
			retorno.setIdJogo(rs.getInt("id_jogo"));
			
			
		}
				
		return retorno;
	}

}