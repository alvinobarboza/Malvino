package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.model.Jogadores;

public class JogadoresDAO extends HibernateDAO<Jogadores> {


	public JogadoresDAO() {
		super(Jogadores.class);
	}

	public Jogadores existOne(String login, String email) throws SQLException {
		
		PerfisDAO dao = new PerfisDAO();
		Jogadores retorno = new Jogadores();
		retorno.setLogin("Login errado");
		retorno.setEmail("Email errado");
		
		String sql = "select * from malvino.jogadores j "
				+ "where j.ds_login = ? or j.ds_email = ?";
		
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, login);
		ps.setString(2, email);
		
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
	
	public Jogadores recuperarSenha(String email) throws SQLException {
		
		PerfisDAO dao = new PerfisDAO();
		Jogadores retorno = new Jogadores();
		retorno.setEmail(" EmailController"+email+" não encontrado");
		
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
	
	public List<Jogadores> getByName(Jogadores temp) throws SQLException {
		
		PerfisDAO dao = new PerfisDAO();
		List<Jogadores> retorno = new ArrayList<Jogadores>();
		
		
		String sql = "select * from malvino.jogadores j where UPPER(j.ds_nome) like UPPER('%"+temp.getNome()+"%')";
		
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		
		
		ResultSet rs = ps.executeQuery() ;
		
		while(rs.next()){
			
			Jogadores busca = new Jogadores();
			
			busca.setIdJogador(rs.getInt("id_jogador"));
			busca.setPerfis(dao.getBean(rs.getInt("fk_perfil")));
			busca.setNome(rs.getString("ds_nome"));
			busca.setLogin(rs.getString("ds_login"));
			busca.setSenha(rs.getString("ds_senha"));
			busca.setEmail(rs.getString("ds_email"));
			busca.setGenero(rs.getString("ds_genero"));
			busca.getClas().setIdCla(rs.getInt("fk_cla"));
			
			retorno.add(busca);
			
		}
		
		return retorno;
	}
	
	 

}