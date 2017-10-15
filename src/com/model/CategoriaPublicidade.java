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
@Table(name = "jogadores_jogos")
public class CategoriaPublicidade extends BaseModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pfk_publicidade")
	private Publicidades publicidades;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pfk_categoria")
	private Categorias categorias;
	
	@Column(name="dt_data_cadastro")
	private Date dataRegistro;

	public Publicidades getPublicidade() {
		if(publicidades == null)
			publicidades = new Publicidades();
		return publicidades;
	}

	public void setPublicidade(Publicidades publicidade) {
		this.publicidades = publicidade;
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
