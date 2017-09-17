package com.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.dao.JogadoresDAO;
import com.model.Jogadores;

@ManagedBean
@SessionScoped
public class LoginBean extends BaseBean {
	private static Jogadores jogadores;
	private JogadoresDAO jogadoresDAO;

	public Jogadores getJogadores() {
		if (jogadores == null)
			jogadores = new Jogadores();
		return jogadores;
	}

	@SuppressWarnings("static-access")
	public void setJogadores(Jogadores jogadores) {
		this.jogadores = jogadores;
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
			Jogadores idJogador = getJogadoresDAO().existOne(getJogadores().getLogin(), getJogadores().getSenha());

			if (idJogador.getIdJogador() == 0) {
				showInfo("Jogadores e/ou senha inválidos");
				return null;
			} else {
				setJogadores(getJogadoresDAO().getBean(idJogador.getIdJogador()));
				showInfo("Usuário autenticado com sucesso!");
				return "/pages/jogadores/list.xhtml?faces-redirect=true";
			}

		} catch (Exception ex) {
			showError("Erro ao tentar autenticar no sistema!" + ex.getMessage());
			return null;
		}
	}

	public String logout() {
		jogadores = null;
		showInfo("Usuário Desconectado com sucesso!");
		return "/pages/login.xhtml?faces-redirect=true";
	}
}
