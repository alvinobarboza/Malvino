package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;

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
				+ "where j.ds_login = ? and j.ds_senha = ?";
		
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, login);
		ps.setString(2, senha);
		
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

		final Query query = session.createQuery("select j from Jogadores j where j.login = :login and j.senha = :senha");

		query.setString("login", login);
		query.setString("senha", senha);

		@SuppressWarnings("unchecked")
		final List<Jogadores> jogadores = query.list();

		return !jogadores.isEmpty();

	}

}