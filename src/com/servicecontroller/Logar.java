package com.servicecontroller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Logar {
	private String login;
	private String senha;
	int teste;
	
	public int getTeste() {
		return teste;
	}
	public void setTeste(int teste) {
		this.teste = teste;
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
}
