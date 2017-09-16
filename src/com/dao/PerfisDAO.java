package com.dao;

import com.model.Perfis;

public class PerfisDAO extends HibernateDAO<Perfis>{
	public PerfisDAO()
	{
		super(Perfis.class);
	}
}
