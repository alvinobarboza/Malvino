
package com.dao;

import com.model.JogadoresJogos;

public class CategoriaPublicidadeDAO extends HibernateDAO<JogadoresJogos>{
	public CategoriaPublicidadeDAO()
	{
		super(JogadoresJogos.class);
	}
}
