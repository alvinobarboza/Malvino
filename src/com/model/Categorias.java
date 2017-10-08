package com.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
@SequenceGenerator(name="categoria_seq", sequenceName="categorias_id_categoria_seq", allocationSize = 1)
public class Categorias {
	
	@Id
	@Column(name = "id_categoria")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="categoria_seq")
	int idCategoria;
	
	@Column(name = "ds_nome_categoria")
	String NomeCategoria;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categorias")
	private List<JogosCategoria> jogosCategorias;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "publicidade")
	private List<CategoriaPublicidade> categoriPublicidade;
	
	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomeCategoria() {
		return NomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		NomeCategoria = nomeCategoria;
	}
	

}
