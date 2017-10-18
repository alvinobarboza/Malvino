package com.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "jogadores")
@SequenceGenerator(name="jogador_seq", sequenceName="seq_jogadores", allocationSize = 1)
public class Jogadores extends BaseModel {
	
	@Id
	@Column(name = "id_jogador")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="jogador_seq")
	private int idJogador;
	
	@Column(name = "ds_nome")
	private String nome;
	
	@Column(name = "ds_login")
	private String login;
	
	@Column(name = "ds_senha")
	private String senha;
	
	@Column(name = "ds_email")
	private String email;
	
	@Column(name = "ds_genero")
	private String genero;
	
	@Column(name = "nu_ativo")
	boolean Ativo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_perfil")
	private Perfis perfis;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_cla")
	private Clas clas;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jogadores")
	private List<JogadoresJogos> jogadoresJogos;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jogadorSolicitante")
	private List<Amigos> solicitante;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jogadorSolicitado")
	private List<Amigos> solicitado;

	public boolean isAtivo() {
		return Ativo;
	}
	
	
	public void setAtivo(boolean ativo) {
		Ativo = ativo;
	}
	
	public int getIdJogador() {
		return idJogador;
	}


	public void setIdJogador(int idJogador) {
		this.idJogador = idJogador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Clas getClas() {
		if (clas == null) {
			clas = new Clas();
		}
		return clas;
	}

	public void setCla(Clas clas) {
		this.clas = clas;
	}
	

	public Perfis getPerfis() {
		if (perfis == null) {
			perfis = new Perfis();
		}
		return perfis;
	}

	public void setPerfis(Perfis perfis) {
		this.perfis = perfis;
	}
}
