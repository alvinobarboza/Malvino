package com.model;

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
public class CategoriaPublicidade extends BaseModel {
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pfk_publicidade")
	private Publicidades publicidade;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pfk_categoria")
	private Categorias categoria;
	
	@Column(name="dt_data_cadastro")
	private Date dataRegistro;

	public Publicidades getPublicidade() {
		if(publicidade == null)
			publicidade = new Publicidades();
		return publicidade;
	}

	public void setPublicidade(Publicidades publicidade) {
		this.publicidade = publicidade;
	}

	public Categorias getCategoria() {
		if(categoria == null)
			categoria = new Categorias();
		return categoria;
	}

	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}
}
