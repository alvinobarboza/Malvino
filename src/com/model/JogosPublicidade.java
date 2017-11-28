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
public class JogosPublicidade extends BaseModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pfk_jogo")
	private Jogos jogos;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pfk_publicidade")
	private Publicidades publicidades;
	
	
	public Jogos getJogo() {
		if(jogos == null)
			jogos = new Jogos();
		return jogos;
	}

	public void setJogo(Jogos jogo) {
		this.jogos = jogo;
	}

	public Publicidades getPublicidade() {
		if(publicidades == null)
			publicidades = new Publicidades();
		return publicidades;
	}

	public void setPublicidade(Publicidades publicidade) {
		this.publicidades = publicidade;
	}
	
}
