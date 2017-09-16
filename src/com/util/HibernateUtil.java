package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static AnnotationConfiguration configuration;
	
	static
	{
		configuration = new AnnotationConfiguration()
		.configure("/com/util/hibernate.cfg.xml");
		
	}

	public static SessionFactory getSessionFactory() {
		sessionFactory = configuration.buildSessionFactory();
		return sessionFactory;
	}
}
