package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import javax.persistence.Query;

import org.hibernate.SQLQuery;

import com.model.Jogadores;

public class JogadoresDAO extends HibernateDAO<Jogadores> {

	private static final boolean Jogadores = false;
	protected EntityManager em;

	public JogadoresDAO() {
		super(Jogadores.class);
	}

	public int existOne(String login, String senha) throws SQLException {
		
		int retorno = 0;
		
		Jogadores jogadores = new Jogadores();
		JogadoresDAO dao = new JogadoresDAO();
		
		jogadores.setLogin(login);
		jogadores.setSenha(senha);
		
		
		
		List<Jogadores> list = dao.getBeansByExample(jogadores);
		
		for(Jogadores jogador: list){
			retorno = jogador.getIdJogador();
		}
		
		return retorno;
	}

	/*public int existOne(String codigo) throws SQLException {
		int retorno = 0;

		Query q = em.createNativeQuery(" select * " + 
				"	from malvino.jogadores where  " + " id_jogador = '" + codigo + "'");

		ResultSet rs = (ResultSet) q.getResultList();

		while (rs.next()) {
			retorno = rs.getInt("id_jogador");
		}
		return retorno;
	}*/

}
