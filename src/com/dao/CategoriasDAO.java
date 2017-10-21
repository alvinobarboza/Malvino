package com.dao;

import com.model.Categorias;;

public class CategoriasDAO extends HibernateDAO<Categorias> {

	public CategoriasDAO() {
		super(Categorias.class);
	}

}