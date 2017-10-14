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
@Table(name = "amigos")
public class Amigos extends BaseModel{
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pfk_jogador_solicitante")
	private Jogadores jogadorSolicitante;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pfk_jogador_solicitado")
	private Jogadores jogadorSolicitado;
	
	@Column(name="dt_data_solicitacao")
	private Date dataSolicitacao;
	
	@Column(name="dt_data_confirmacao")
	private Date dataConfirmacao;
	
	@Column(name="ds_situacao")
	private String situacao;

	
	
	public Jogadores getJogadorSolicitante() {
		if(jogadorSolicitante == null)
			jogadorSolicitante = new Jogadores();
		return jogadorSolicitante;
	}

	public void setJogadorSolicitante(Jogadores jogadorSolicitante) {
		this.jogadorSolicitante = jogadorSolicitante;
	}

	public Jogadores getJogadorSolicitado() {
		if(jogadorSolicitado == null)
			jogadorSolicitado = new Jogadores();
		return jogadorSolicitado;
	}

	public void setJogadorSolicitado(Jogadores jogadorSolicitado) {
		this.jogadorSolicitado = jogadorSolicitado;
	}

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public Date getDataConfirmacao() {
		return dataConfirmacao;
	}

	public void setDataConfirmacao(Date dataconfirmacao) {
		this.dataConfirmacao = dataconfirmacao;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	
}
