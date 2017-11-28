package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.JogosCategoria;

public class JogosCategoriaDAO extends HibernateDAO<JogosCategoria>{
	public JogosCategoriaDAO()
	{
		super(JogosCategoria.class);
	}
	
	public JogosCategoria getBeanID(int id1, int id2) throws SQLException {
		
		JogosCategoria retorno = new JogosCategoria();
		JogosDAO jogosDAO = new JogosDAO();
		CategoriasDAO categoriasDAO = new CategoriasDAO();
		
		String sql = "select * from malvino.Jogos_Categorias j "
				+ "where j.pfk_jogo = ? and j.pfk_categoria = ?";
		
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setInt(1, id1);
		ps.setInt(2, id2);
		
		ResultSet rs = ps.executeQuery() ;
		
		while(rs.next()){
		
			retorno.setJogos(jogosDAO.getBean(rs.getInt("pfk_jogo")));
			retorno.setCategorias(categoriasDAO.getBean(rs.getInt("pfk_categoria")));
			
			
		}
		
		return retorno;
	}
}
