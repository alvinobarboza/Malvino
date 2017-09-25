package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.persistence.EntityManager;

import com.model.Jogadores;

public class JogadoresDAO extends HibernateDAO<Jogadores> {

	private static final boolean Jogadores = false;
	protected EntityManager em;

	public JogadoresDAO() {
		super(Jogadores.class);
	}

	public Jogadores existOne(String login, String senha) throws SQLException {
		
		Jogadores retorno = new Jogadores();
		retorno.setLogin("Login errado");
		
		String sql = "select * from malvino.jogadores j "
				+ "where j.ds_login = '"+login+"' and j.ds_senha = '"+senha+"'";
		
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery() ;
		
		while(rs.next()){
		
			retorno.setIdJogador(rs.getInt("id_jogador"));
			retorno.getPerfis().setIdPerfil(rs.getInt("id_perfil"));
			retorno.setNome(rs.getString("ds_nome"));
			retorno.setLogin(rs.getString("ds_login"));
			retorno.setSenha(rs.getString("ds_senha"));
			retorno.setGenero(rs.getString("ds_genero"));
			retorno.getClas().setIdCla(rs.getInt("id_cla"));
			
		}
		
		return retorno;
	}
	public boolean login(String login, String senha) throws SQLException {
		
		boolean retorno = false;
		
		String sql = "select * from malvino.jogadores j "
				+ "where j.ds_login = '"+login+"' and j.ds_senha = '"+senha+"'";
		
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery() ;
		
		while(rs.next()){
			if(rs.getString("ds_login").equals(login) 
					& rs.getString("ds_senha").equals(senha)){
				retorno = true;
			}
			
		}
		
		return retorno;
	}

}