package com.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "perfis")
@Entity
public class Perfis extends BaseModel {
	@Id
	@Column(name = "id_perfil")
	private int idPerfil;
	
	@Column(name = "ds_nome")
	private String nome;
	
	@Column(name = "ds_descricao")
	private String descricao;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "perfis")
	private List<Jogadores> jogadores;

	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
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

}
