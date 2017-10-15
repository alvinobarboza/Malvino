package com.dao;

import com.model.Amigos;

public class AmigosDAO extends HibernateDAO<Amigos>{
	public AmigosDAO()
	{
		super(Amigos.class);
	}
}