package com.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface InterfaceDAO<T> {
	void salvar(T bean);
	void atualizar(T bean);
	void excluir(T bean);
	void salvar(Collection<T> beans);
	void atualizar(Collection<T> beans);	
	T getBean(Serializable codigo);
	List<T> getBeans();
	List<T> getBeans(Integer inicio, Integer total);
	List<T> getBeansByExample(T bean);
	List<T> getBeansByExample(T bean, Integer inicio, Integer total);
	Integer getTotalRegistros(T bean);
	List<T> getBeansByIds(String atributo, List<Serializable> codigos);
}
