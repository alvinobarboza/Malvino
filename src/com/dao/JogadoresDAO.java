package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;

import com.model.Jogadores;

public class JogadoresDAO extends HibernateDAO<Jogadores> {


	public JogadoresDAO() {
		super(Jogadores.class);
	}

	public Jogadores existOne(String login, String senha) throws SQLException {
		
		PerfisDAO dao = new PerfisDAO();
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
			retorno.setPerfis(dao.getBean(rs.getInt("fk_perfil")));
			retorno.setNome(rs.getString("ds_nome"));
			retorno.setLogin(rs.getString("ds_login"));
			retorno.setSenha(rs.getString("ds_senha"));
			retorno.setGenero(rs.getString("ds_genero"));
			retorno.getClas().setIdCla(rs.getInt("fk_cla"));
			
		}
		
		return retorno;
	}
	
	public Jogadores recuperarSenha(String email) throws SQLException {
		
		PerfisDAO dao = new PerfisDAO();
		Jogadores retorno = new Jogadores();
		retorno.setEmail(" Email"+email+" não encontrado");
		
		String sql = "select * from malvino.jogadores j "
				+ "where j.ds_email = ?";
		
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, email);
		
		ResultSet rs = ps.executeQuery() ;
		
		while(rs.next()){
		
			retorno.setIdJogador(rs.getInt("id_jogador"));
			retorno.setPerfis(dao.getBean(rs.getInt("fk_perfil")));
			retorno.setNome(rs.getString("ds_nome"));
			retorno.setLogin(rs.getString("ds_login"));
			retorno.setSenha(rs.getString("ds_senha"));
			retorno.setEmail(rs.getString("ds_email"));
			retorno.setGenero(rs.getString("ds_genero"));
			retorno.getClas().setIdCla(rs.getInt("fk_cla"));
			
		}
		
		return retorno;
	}
	
	public Jogadores login(String login, String senha) throws SQLException {

		Jogadores retorno = new Jogadores();
		
		String sql = "select * from malvino.jogadores j "
				+ "where j.ds_login = ? and j.ds_senha = ?";
		
		retorno.setLogin("Login ou senha incorreta!");
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, login);
		ps.setString(2, senha);
		
		ResultSet rs = ps.executeQuery() ;
		
		while(rs.next()){
		
			retorno.setIdJogador(rs.getInt("id_jogador"));
			retorno.setLogin(rs.getString("ds_login"));
			retorno.setSenha(rs.getString("ds_senha"));
			
		}
		
		return retorno;

	}

}