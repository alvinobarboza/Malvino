package com.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="clas")
@Entity
@SequenceGenerator(name="cla_seq", sequenceName="seq_clas", allocationSize = 1)
public class Clas extends BaseModel {
	
	@Id
	@Column(name="id_cla")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cla_seq")
	private int idCla;
	
	@Column(name="ds_nome")
	private String nome;
	
	@Column(name="nu_qtd_membros")
	private int qtdMenbros;
	
	@Column(name="ds_descricao")
	private String descricao;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clas")
	private List<Jogadores> jogadores;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clas")
	private List<JogadoresJogos> jogadoresJogos;

	public List<Jogadores> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogadores> jogadores) {
		this.jogadores = jogadores;
	}

	public int getIdCla() {
		return idCla;
	}

	public void setIdCla(int idCla) {
		this.idCla = idCla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtdMenbros() {
		return qtdMenbros;
	}

	public void setQtdMenbros(int qtdMenbros) {
		this.qtdMenbros = qtdMenbros;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
