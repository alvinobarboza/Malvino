package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "jogos")
@SequenceGenerator(name="jogo_seq", sequenceName="jogos_id_jogo_seq", allocationSize = 1)
public class Jogos {
	
	@Id
	@Column(name = "id_jogador")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="jogador_seq")
	int idJogo;
	
	@Column(name = "ds_nome")
	String nome;
	
	@Column(name = "ds_descricao")
	String descricao;
	
	@Column(name = "nu_ativo")
	boolean Ativo;

	public int getIdJogo() {
		return idJogo;
	}

	public void setIdJogo(int idJogo) {
		this.idJogo = idJogo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isAtivo() {
		return Ativo;
	}

	public void setAtivo(boolean ativo) {
		Ativo = ativo;
	}
	
	
	
}
