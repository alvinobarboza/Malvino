package com.view;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.HibernateDAO;
import com.model.Jogadores;

public class UsuarioView extends HibernateDAO<Jogadores> {

	public UsuarioView() {
		super(Jogadores.class);
	}

	public int existOne(String codigo) throws SQLException {
		int retorno = 0;

		ResultSet rs = super.getResultSet(
				" select * " + "	from view_usuario where  " + " id_usuario = '" + codigo + "'");

		while (rs.next()) {
			retorno = rs.getInt("id_usuario");
		}
		return retorno;
	}

}
