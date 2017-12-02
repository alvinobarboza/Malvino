package com.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.dao.JogadoresDAO;
import com.model.Jogadores;

@ManagedBean
@SessionScoped
public class LoginBean extends BaseBean {
	private static int verifica = 1;
	private JogadoresDAO jogadoresDAO;
	
	private String login;
	private String senha;
	
	

	public String getLogin() {
		return login;
	}

	public void setLogin(String usuario) {
		this.login = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getVerifica() {
		return verifica;
	}

	@SuppressWarnings("static-access")
	public void setJogadores(int verifica) {
		this.verifica = verifica;
	}

	public JogadoresDAO getJogadoresDAO() {
		if (jogadoresDAO == null)
			jogadoresDAO = new JogadoresDAO();
		return jogadoresDAO;
	}

	public void setJogadoresDAO(JogadoresDAO jogadoresDAO) {
		this.jogadoresDAO = jogadoresDAO;
	}

	public String autenticar() {
		try {
			Jogadores idJogador = getJogadoresDAO().login(getLogin(), getSenha());
			System.out.println(idJogador.getPerfis().getNome());
			if (idJogador.getIdJogador() == 1) {
				setJogadores(2);
				showInfo("Usuário autenticado com sucesso!");
				return "/pages/jogadores/list.xhtml?faces-redirect=true";
				
			} else {
				showInfo("Jogadores e/ou senha inválidos");
				return null;
			}

		} catch (Exception ex) {
			showError("Erro ao tentar autenticar!" + ex.getMessage());
			return null;
		}
	}

	public String logout() {
		setJogadores(1);
		showInfo("Usuário Desconectado com sucesso!");
		return "/pages/login.xhtml?faces-redirect=true";
	}
}
