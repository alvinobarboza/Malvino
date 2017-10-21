package com.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.dao.CategoriasDAO;
import com.model.JogosCategoria;
import com.model.Jogos;
import com.model.Categorias;
import com.dao.JogosCategoriaDAO;
import com.dao.JogosDAO;

@ManagedBean
@SessionScoped
public class JogosCategoriaBean extends BaseBean implements IBO, ICRUDBean {
	private Jogos jogos;
	private JogosDAO jogosDAO;
	private Categorias Categorias;
	private CategoriasDAO CategoriasDAO;
	private JogosCategoria jogosCategoria;
	private JogosCategoriaDAO JogosCategoriaDAO;
	private List<Jogos> listJogos;
	private List<Categorias> listCategorias;
	private List<JogosCategoria> listJogosCategorias;
	private int codigoJogo;
	private int codigoCategoria;
		
	
	public Jogos getJogos() {
		if(jogos == null)
			jogos = new Jogos();
		return jogos;
	}

	public void setJogos(Jogos jogos) {
		this.jogos = jogos;
	}

	public JogosDAO getJogosDAO() {
		if(jogosDAO == null)
			jogosDAO = new JogosDAO();
		return jogosDAO;
	}

	public void setJogosDAO(JogosDAO jogosDAO) {
		this.jogosDAO = jogosDAO;
	}

	public JogosCategoria getJogosCategoria() {
		if(jogosCategoria == null)
			jogosCategoria = new JogosCategoria();
		return jogosCategoria;
	}

	public void setJogosCategoria(JogosCategoria jogosCategoria) {
		this.jogosCategoria = jogosCategoria;
	}

	public JogosCategoriaDAO getJogosCategoriaDAO() {
		if (JogosCategoriaDAO == null)
			JogosCategoriaDAO = new JogosCategoriaDAO();
		return JogosCategoriaDAO;
	}

	public void setJogosCategoriaDAO(JogosCategoriaDAO jogosCategoriaDAO) {
		JogosCategoriaDAO = jogosCategoriaDAO;
	}

	public List<Jogos> getListJogos() {
		
		if(listJogos == null){
			listJogos = getJogosDAO().getBeans();
		}
		return listJogos;
		
	}

	public List<JogosCategoria> getListJogosCategorias() {
		if(listJogosCategorias == null)
			listJogosCategorias = getJogosCategoriaDAO().getBeans();
		return listJogosCategorias;
	}


	public Categorias getCategorias() {
		if (Categorias == null)
			Categorias = new Categorias();
		return Categorias;
	}

	public void setCategorias(Categorias Categorias) {
		this.Categorias = Categorias;
	}

	public CategoriasDAO getCategoriasDAO() {
		if (CategoriasDAO == null)
			CategoriasDAO = new CategoriasDAO();
		return CategoriasDAO;
	}

	public void setCategoriasDAO(CategoriasDAO CategoriasDAO) {
		this.CategoriasDAO = CategoriasDAO;
	}

	public List<Categorias> getListCategorias() {
		if(listCategorias == null)
			listCategorias = getCategoriasDAO().getBeans();
		return listCategorias;
	}

	public void setListCategorias(List<Categorias> listCategorias) {
		this.listCategorias = listCategorias;
	}

	public int getCodigoJogo() {
		return codigoJogo;
	}

	public void setCodigoJogo(int codigo) {
		this.codigoJogo = codigo;
	}
	
	public int getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(int codigo) {
		this.codigoCategoria = codigo;
	}

	public void listJogosCategoria(){
		listJogosCategorias = getJogosCategoriaDAO().getBeans();
	}
	public void listJogos(){
		listJogos = getJogosDAO().getBeans();
	}
	public void listCategorias(){
		listCategorias = getCategoriasDAO().getBeans();
	}
	
	@Override
	public void find() {
		try {
			if (codigoJogo != 0 && codigoCategoria != 0)
				jogosCategoria = getJogosCategoriaDAO().getBeanID(codigoJogo,codigoCategoria);
			else
				jogosCategoria = new JogosCategoria();
		} catch (Exception e) {
			showError("Erro ao tentar selecionar.");
		} finally {
			cleanMessageFlags();
		}
	}

	@Override
	public void list() {
		
	}

	@Override
	public void delete() {
		try {
			existDependences();
			if (isMessageError() == false) {
				getJogosCategoriaDAO().excluir(jogosCategoria);
				getJogosCategoriaDAO().commit();
				showInfo("Dados excluidos com sucesso.");
			}
		} catch (Exception e) {
			getJogosCategoriaDAO().rollback();
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
				getJogosCategoriaDAO().atualizar(jogosCategoria);
				getJogosCategoriaDAO().commit();
				showInfo("Dados atualizados com sucesso.");
			}
		} catch (Exception e) {
			getJogosCategoriaDAO().rollback();
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
				getJogosCategoriaDAO().salvar(jogosCategoria);
				getJogosCategoriaDAO().commit();
				showInfo("Dados salvos com sucesso.");
			}

		} catch (Exception e) {
			getJogosCategoriaDAO().rollback();
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
		if (getJogosCategoria().getJogos().getIdJogo() == 0)
			showAlert("Jogo não foi selecionado");
		
		if (getJogosCategoria().getCategorias().getIdCategoria() == 0)
			showAlert("Categoria não foi selecionado");
	}

	@Override
	public void existDependences() {
		// TODO Auto-generated method stub

	}
}
