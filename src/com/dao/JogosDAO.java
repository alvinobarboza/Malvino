package com.dao;

import com.model.Jogos;;

public class JogosDAO extends HibernateDAO<Jogos> {

	private static final boolean Jogos = false;

	public JogosDAO() {
		super(Jogos.class);
	}

}