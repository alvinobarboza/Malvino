package com.dao;

import com.model.JogosPublicidade;

public class JogosPublicidadeDAO extends HibernateDAO<JogosPublicidade>{
	public JogosPublicidadeDAO()
	{
		super(JogosPublicidade.class);
	}
}
