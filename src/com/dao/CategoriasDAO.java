package com.dao;

import com.model.Categorias;;

public class CategoriasDAO extends HibernateDAO<Categorias> {

	private static final boolean Categorias = false;

	public CategoriasDAO() {
		super(Categorias.class);
	}

}