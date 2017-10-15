package com.dao;

import com.model.JogosCategoria;

public class JogosCategoriaDAO extends HibernateDAO<JogosCategoria>{
	public JogosCategoriaDAO()
	{
		super(JogosCategoria.class);
	}
}
