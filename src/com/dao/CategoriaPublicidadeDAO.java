
package com.dao;

import com.model.CategoriaPublicidade;

public class CategoriaPublicidadeDAO extends HibernateDAO<CategoriaPublicidade>{
	public CategoriaPublicidadeDAO()
	{
		super(CategoriaPublicidade.class);
	}
}
