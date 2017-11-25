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
public class JogadoresJogos extends BaseModel implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pfk_jogador")
	private Jogadores jogadores;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pfk_jogo")
	private Jogos jogos;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_cla")
	private Clas clas;
	
	@Column(name="nu_qtd_pontos_recorde")
	private int pontosRecorde;
	
	@Column(name="nu_tempo_recorde")
	private String tempoRecorde;
	
	@Column(name="nu_tempo_jogo")
	private String tempoJogo;
	
	@Column(name="nu_pontos")
	private int pontosTotais;
	
	

	public Jogadores getJogador() {
		if(jogadores == null)
			jogadores = new Jogadores();
		return jogadores;
	}

	public void setJogador(Jogadores jogador) {
		this.jogadores = jogador;
	}

	public Jogos getJogo() {
		if(jogos == null)
			jogos = new Jogos();
		return jogos;
	}

	public void setJogo(Jogos jogo) {
		this.jogos = jogo;
	}

	public Clas getCla() {
		if(clas == null)
			clas = new Clas();
		return clas;
	}

	public void setCla(Clas cla) {
		this.clas = cla;
	}

	public int getPontosRecorde() {
		return pontosRecorde;
	}

	public void setPontosRecorde(int pontosRecorde) {
		if(pontosRecorde>this.pontosRecorde){
		this.pontosRecorde = pontosRecorde;
		}
	}

	public String getTempoRecorde() {
		return tempoRecorde;
	}

	public void setTempoRecorde(String tempoRecorde) {
		this.tempoRecorde = tempoRecorde;
	}

	public String getTempoJogo() {
		return tempoJogo;
	}

	public void setTempoJogo(String tempoJogo) {
		this.tempoJogo = tempoJogo;
	}

	public int getPontosTotais() {
		return pontosTotais;
	}

	public void setPontosTotais(int pontosTotais) {
		this.pontosTotais = this.pontosTotais+pontosTotais;
	}

}
