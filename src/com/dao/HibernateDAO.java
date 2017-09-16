package com.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


public class HibernateDAO<T> extends BaseDAO implements InterfaceDAO<T> {

	private Class<T> classe;
	protected Session session;
	
	public HibernateDAO(Class<T> classe) {
		super();
		this.classe = classe;
		this.session = super.getSession();
	}
	
	public HibernateDAO(Class<T> classe, Session session) {
		super();
		this.classe = classe;
		this.session = session;
	}

	@Override
	public void atualizar(T bean) {
		session.update(bean);
	}

	@Override
	public void excluir(T bean) {
		session.delete(bean);
	}

	@Override
	public T getBean(Serializable codigo) {
		@SuppressWarnings("unchecked")
		T bean = (T)session.get(classe, codigo);
		return bean;
	}

	@Override
	public List<T> getBeans() {
		Criteria crit = session.createCriteria(classe);
		crit.setCacheable(true);

		@SuppressWarnings("unchecked")
		List<T> beans = (List<T>)crit.list();
		return beans;
	}

	@Override
	public void salvar(T bean) {
		session.save(bean);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getBeansByExample(T bean) {
		Example example = getExample(bean);
		return session.createCriteria(classe).add(example).list();
	}
	
	protected Example getExample(T bean)
	{
		Example example = Example.create(bean);
		example.enableLike(MatchMode.START);
		example.ignoreCase();
		example.excludeZeroes();
		return example;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getBeansByIds(String atributo, List<Serializable> codigos) {
		try{
			if(codigos.size() == 1)
			{
				List<T> resultado = new ArrayList<T>();
				resultado.add(getBean(codigos.get(0)));
				return resultado;
			}else if(codigos.size() > 1)
			{
				Criteria crit = session.createCriteria(classe);
				crit.add(Restrictions.in("codigo", codigos));
				return crit.list();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ArrayList<T>();					
	}

	@Override
	public void salvar(Collection<T> beans) {
		Iterator<T> it = beans.iterator();
		int i = 0;
		while(it.hasNext())
		{
			session.save(it.next());
			if(i % 20 == 0 || i >= beans.size() -1)
			{
				session.flush();
				session.clear();
			}
			i++;
		}
	}

	@Override
	public void atualizar(Collection<T> beans) {
		Iterator<T> it = beans.iterator();
		int i = 0;
		while(it.hasNext())
		{
			session.update(it.next());
			if(i % 20 == 0 || i >= beans.size() -1)
			{
				session.flush();
				session.clear();
			}
			i++;
		}
	}

	@SuppressWarnings("unchecked")
	protected List<T> getBeansAux(Criteria crit, Integer inicio, Integer total)
	{
		crit.setFirstResult(inicio);
		crit.setMaxResults(total);
		return crit.list();
	}
	
	@Override
	public List<T> getBeans(Integer inicio, Integer total) {
		Criteria crit = session.createCriteria(classe);		
		return getBeansAux(crit, inicio, total);
	}

	@Override
	public List<T> getBeansByExample(T bean, Integer inicio, Integer total) {
		Criteria crit = session.createCriteria(classe).add(getExample(bean));		
		return getBeansAux(crit, inicio, total);
	}

	@Override
	public Integer getTotalRegistros(T bean) {
		Criteria crit = session.createCriteria(classe).setProjection(Projections.rowCount());
		crit.add(getExample(bean));
		return (Integer)crit.uniqueResult();
	}
}
