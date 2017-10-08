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
public class JogosPublicidade extends BaseModel {
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pfk_jogo")
	private Jogos jogo;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pfk_publicidade")
	private Publicidades publicidade;
	
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
	
	public Date getDataRegistro() {
		return dataRegistro;
	}

	public Publicidades getPublicidade() {
		if(publicidade == null)
			publicidade = new Publicidades();
		return publicidade;
	}

	public void setPublicidade(Publicidades publicidade) {
		this.publicidade = publicidade;
	}
	
}
