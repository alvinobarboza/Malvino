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
@Table(name = "categorias_publicidades")
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

	public Publicidades getPublicidades() {
		if(publicidades == null)
			publicidades = new Publicidades();
		return publicidades;
	}

	public void setPublicidades(Publicidades publicidade) {
		this.publicidades = publicidade;
	}

	public Categorias getCategorias() {
		if(categorias == null)
			categorias = new Categorias();
		return categorias;
	}

	public void setCategorias(Categorias categoria) {
		this.categorias = categoria;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}
}
