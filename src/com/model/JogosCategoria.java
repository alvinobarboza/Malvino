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
@Table(name = "jogos_categorias")
public class JogosCategoria extends BaseModel {
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pfk_jogo")
	private Jogos jogo;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pfk_categoria")
	private Categorias categoria;
	
	@Column(name="dt_data_cadastro")
	private Date dataRegistro;
	
	public Jogos getJogo() {
		if(jogo == null)
			jogo = new Jogos();
		return jogo;
	}

	public void setJogo(Jogos jogo) {
		this.jogo = jogo;
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
