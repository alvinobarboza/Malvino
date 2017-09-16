package com.dao;

import com.model.Publicidades;;

public class PublicidadesDAO extends HibernateDAO<Publicidades> {

	private static final boolean Publicidades = false;

	public PublicidadesDAO() {
		super(Publicidades.class);
	}

}
