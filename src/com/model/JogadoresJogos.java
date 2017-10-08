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
public class JogadoresJogos extends BaseModel {
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pfk_jogador")
	private Jogadores jogador;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pfk_jogo")
	private Jogos jogo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_cla")
	private Clas cla;
	
	@Column(name="nu_qtd_pontos_recorde")
	private int pontosRecorde;
	
	@Column(name="nu_tempo_recorde")
	private Date tempoRecorde;
	
	@Column(name="nu_tempo_jogo")
	private Date tempoJogo;
	
	@Column(name="nu_pontos")
	private int pontosTotais;
	
	@Column(name="dt_data_cadastro")
	private Date dataRegistro;
	

	public Jogadores getJogador() {
		if(jogador == null)
			jogador = new Jogadores();
		return jogador;
	}

	public void setJogador(Jogadores jogador) {
		this.jogador = jogador;
	}

	public Jogos getJogo() {
		if(jogo == null)
			jogo = new Jogos();
		return jogo;
	}

	public void setJogo(Jogos jogo) {
		this.jogo = jogo;
	}

	public Clas getCla() {
		if(cla == null)
			cla = new Clas();
		return cla;
	}

	public void setCla(Clas cla) {
		this.cla = cla;
	}

	public int getPontosRecorde() {
		return pontosRecorde;
	}

	public void setPontosRecorde(int pontosRecorde) {
		this.pontosRecorde = pontosRecorde;
	}

	public Date getTempoRecorde() {
		return tempoRecorde;
	}

	public void setTempoRecorde(Date tempoRecorde) {
		this.tempoRecorde = tempoRecorde;
	}

	public Date getTempoJogo() {
		return tempoJogo;
	}

	public void setTempoJogo(Date tempoJogo) {
		this.tempoJogo = tempoJogo;
	}

	public int getPontosTotais() {
		return pontosTotais;
	}

	public void setPontosTotais(int pontosTotais) {
		this.pontosTotais = pontosTotais;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}
}
