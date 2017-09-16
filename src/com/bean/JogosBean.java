package com.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.dao.JogosDAO;
import com.model.Jogos;

@ManagedBean
@SessionScoped
public class JogosBean extends BaseBean implements IBO, ICRUDBean {
	private Jogos Jogos;
	private JogosDAO JogosDAO;
	private List<Jogos> listJogos;
	private int codigo;
	private String acao;// create, update, delete

	public Jogos getJogos() {
		if (Jogos == null)
			Jogos = new Jogos();
		return Jogos;
	}

	public void setJogos(Jogos Jogos) {
		this.Jogos = Jogos;
	}

	public JogosDAO getJogosDAO() {
		if (JogosDAO == null)
			JogosDAO = new JogosDAO();
		return JogosDAO;
	}

	public void setJogosDAO(JogosDAO JogosDAO) {
		this.JogosDAO = JogosDAO;
	}

	public List<Jogos> getListJogos() {
		return listJogos;
	}

	public void setListJogos(List<Jogos> listJogos) {
		this.listJogos = listJogos;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}
	
	public void listJogos(){
		listJogos = getJogosDAO().getBeans();
	}
	
	@Override
	public void find() {
		try {
			if (codigo != 0)
				Jogos = getJogosDAO().getBean(codigo);
			else
				Jogos = new Jogos();
		} catch (Exception e) {
			showError("Erro ao tentar selecionar.");
		} finally {
			cleanMessageFlags();
		}
	}

	@Override
	public void list() {
		if (isNullOrEmpty(getJogos().getNome()) == false) {
			Jogos bean = new Jogos();
			bean.setNome(getJogos().getNome());
			
			listJogos = getJogosDAO().getBeansByExample(bean);
		} else {
			listJogos = getJogosDAO().getBeans();
		}
	}

	@Override
	public void delete() {
		try {
			existDependences();
			if (isMessageError() == false) {
				getJogosDAO().excluir(Jogos);
				getJogosDAO().commit();
				showInfo("Dados excluidos com sucesso.");
			}
		} catch (Exception e) {
			getJogosDAO().rollback();
			showError("Erro ao excluir: " + e.getMessage());
		} finally {
			cleanMessageFlags();
		}
	}

	@Override
	public void edit() {
		try {
			validateModel();
		
			if (isMessageError() == false && isMessageAlert() == false) {
				getJogosDAO().atualizar(Jogos);
				getJogosDAO().commit();
				showInfo("Dados atualizados com sucesso.");
			}
		} catch (Exception e) {
			getJogosDAO().rollback();
			showError("Erro ao atualizar: " + e.getMessage());
		} finally {
			cleanMessageFlags();
		}
	}

	@Override
	public void save() {
		try {
			validateModel();
			validateRule();
			if (isMessageError() == false && isMessageAlert() == false) {
				getJogosDAO().salvar(Jogos);
				getJogosDAO().commit();
				showInfo("Dados salvos com sucesso.");
			}

		} catch (Exception e) {
			getJogosDAO().rollback();
			showError("Erro ao salvar: " + e.getMessage());
		} finally {
			cleanMessageFlags();
		}
	}

	@Override
	public void validateRule() {
	}

	@Override
	public void validateModel() {
		if (isNullOrEmpty(getJogos().getNome()) == true)
			showAlert("Campo Nome é obrigatório");
	
		if (isNullOrEmpty(getJogos().getDescricao()) == true)
			showAlert("Campo Descrição é obrigatório");
		
	}

	@Override
	public void existDependences() {
		// TODO Auto-generated method stub

	}
}
