package com.dao;

import com.model.Jogos;;

public class JogosDAO extends HibernateDAO<Jogos> {

	public JogosDAO() {
		super(Jogos.class);
	}

}