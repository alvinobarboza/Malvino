package com.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "jogos_categorias")
public class JogosCategoria extends BaseModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pfk_jogo")
	private Jogos jogos;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pfk_categoria")
	private Categorias categorias;
	
	@Column(name="dt_data_cadastro")
	private Date dataRegistro;
	
	public Jogos getJogo() {
		if(jogos == null)
			jogos = new Jogos();
		return jogos;
	}

	public void setJogo(Jogos jogo) {
		this.jogos = jogo;
	}

	public Categorias getCategoria() {
		if(categorias == null)
			categorias = new Categorias();
		return categorias;
	}

	public void setCategoria(Categorias categoria) {
		this.categorias = categoria;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}
}
