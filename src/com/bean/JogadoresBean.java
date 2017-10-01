package com.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.dao.PerfisDAO;
import com.dao.JogadoresDAO;
import com.model.Perfis;
import com.model.Jogadores;
import com.view.UsuarioView;

@ManagedBean
@SessionScoped
public class JogadoresBean extends BaseBean implements IBO, ICRUDBean {
	private Jogadores jogadores;
	private JogadoresDAO jogadoresDAO;
	private List<Jogadores> listJogadores;
	private List<Perfis> listPerfis;
	private PerfisDAO perfisDAO;
	private int codigo;
	private String acao;// create, update, delete

	public List<Perfis> getListPerfis() {
		if (listPerfis == null) {
			listPerfis = getPerfisDAO().getBeans();
		}
		return listPerfis;
	}

	public void setListPerfis(List<Perfis> listPerfis) {
		this.listPerfis = listPerfis;
	}

	public Jogadores getJogadores() {
		if (jogadores == null)
			jogadores = new Jogadores();
		return jogadores;
	}

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

	public List<Jogadores> getListJogadores() {
		return listJogadores;
	}

	public void setListJogadores(List<Jogadores> listJogadores) {
		this.listJogadores = listJogadores;
	}

	public PerfisDAO getPerfisDAO() {
		if (perfisDAO == null)
			perfisDAO = new PerfisDAO();
		return perfisDAO;
	}

	public void setPerfisDAO(PerfisDAO perfisDAO) {
		this.perfisDAO = perfisDAO;
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
	
	public void listJogadores(){
		listJogadores = getJogadoresDAO().getBeans();
	}
	
	@Override
	public void find() {
		try {
			if (codigo != 0)
				jogadores = getJogadoresDAO().getBean(codigo);
			else
				jogadores = new Jogadores();
		} catch (Exception e) {
			showError("Erro ao tentar selecionar.");
		} finally {
			cleanMessageFlags();
		}
	}

	@Override
	public void list() {
		if (isNullOrEmpty(getJogadores().getNome()) == false) {
			Jogadores bean = new Jogadores();
			bean.setNome(getJogadores().getNome());
			
			listJogadores = getJogadoresDAO().getBeansByExample(bean);
		} else {
			listJogadores = getJogadoresDAO().getBeans();
		}
	}

	@Override
	public void delete() {
		try {
			existDependences();
			if (isMessageError() == false) {
				getJogadoresDAO().excluir(jogadores);
				getJogadoresDAO().commit();
				showInfo("Dados excluidos com sucesso.");
			}
		} catch (Exception e) {
			getJogadoresDAO().rollback();
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
				getJogadoresDAO().atualizar(jogadores);
				getJogadoresDAO().commit();
				showInfo("Dados atualizados com sucesso.");
			}
		} catch (Exception e) {
			getJogadoresDAO().rollback();
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
				getJogadoresDAO().salvar(jogadores);
				getJogadoresDAO().commit();
				showInfo("Dados salvos com sucesso.");
			}

		} catch (Exception e) {
			getJogadoresDAO().rollback();
			showError("Erro ao salvar: " + e.getMessage());
		} finally {
			cleanMessageFlags();
		}
	}

	@Override
	public void validateRule() {
		if (isNullOrEmpty(getJogadores().getSenha()) == false && getJogadores().getSenha().length() < 8) {
			showError("A senha deve ter no minímo 8 caracteres");
		}
		listJogadores = getJogadoresDAO().getBeans();
		for (Jogadores item : listJogadores) {
			if (getJogadores().getLogin().equals(item.getLogin())||getJogadores().getEmail().equals(item.getLogin())) {
				super.showError("Login já em uso!");
			}
		}
	}

	@Override
	public void validateModel() {
		if (isNullOrEmpty(getJogadores().getNome()) == true)
			showAlert("Campo Nome é obrigatório");
		if (isNullOrEmpty(getJogadores().getLogin()) == true)
			showAlert("Campo Login é obrigatório");
		if (isNullOrEmpty(getJogadores().getSenha()) == true)
			showAlert("Campo Senha é obrigatório");
		if (isNullOrEmpty(getJogadores().getEmail()) == true)
			showAlert("Campo Email é obrigatório");
		if (getJogadores().getPerfis().getIdPerfil() == 0)
			showAlert("Campo Perfis é obrigatório");
		if (isNullOrEmpty(getJogadores().getGenero()) == true)
			showAlert("Campo Genero é obrigatório");
	}

	@Override
	public void existDependences() {
		// TODO Auto-generated method stub

	}
}
