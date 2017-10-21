
package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.CategoriaPublicidade;

public class CategoriaPublicidadeDAO extends HibernateDAO<CategoriaPublicidade>{
	public CategoriaPublicidadeDAO()
	{
		super(CategoriaPublicidade.class);
	}
	
	public CategoriaPublicidade getBeanID(int id1, int id2) throws SQLException {
		
		CategoriaPublicidade retorno = new CategoriaPublicidade();
		PublicidadesDAO publicidadesDAO = new PublicidadesDAO();
		CategoriasDAO categoriasDAO = new CategoriasDAO();
		
		String sql = "select * from malvino.categorias_publicidades j "
				+ "where j.pfk_categoria = ? and j.pfk_publicidade = ?";
		
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setInt(1, id2);
		ps.setInt(2, id1);
		
		ResultSet rs = ps.executeQuery() ;
		
		while(rs.next()){
		
			retorno.setPublicidades(publicidadesDAO.getBean(rs.getInt("pfk_publicidade")));
			retorno.setCategorias(categoriasDAO.getBean(rs.getInt("pfk_categoria")));
			retorno.setDataRegistro(rs.getDate("dt_data_cadastro"));
			
			
		}
		
		return retorno;
	}
}
