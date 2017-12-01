package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<Jogos> getByName(Jogos jogo) throws SQLException {
		
		List<Jogos> list = new ArrayList<Jogos>();
		
		String sql = "select * from malvino.jogos j where UPPER(j.ds_nome) like UPPER('%"+jogo.getNome()+"%') ";
		
		
		PreparedStatement ps = getConnection().prepareStatement(sql);		
		
		ResultSet rs = ps.executeQuery() ;
		
		while(rs.next()){
	
			Jogos retorno = new Jogos();
			retorno.setNome(rs.getString("ds_nome"));
			retorno.setIdJogo(rs.getInt("id_jogo"));
			retorno.setAtivo(rs.getBoolean("nu_ativo"));
			
			list.add(retorno);
			
		}
				
		return list;
	}

}