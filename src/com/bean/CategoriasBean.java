package com.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.dao.CategoriasDAO;
import com.model.Categorias;

@ManagedBean
@SessionScoped
public class CategoriasBean extends BaseBean implements IBO, ICRUDBean {
	private Categorias Categorias;
	private CategoriasDAO CategoriasDAO;
	private List<Categorias> listCategorias;
	private int codigo;
	private String acao;// create, update, delete
	
	
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
		return listCategorias;
	}

	public void setListCategorias(List<Categorias> listCategorias) {
		this.listCategorias = listCategorias;
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
	
	public void listCategorias(){
		listCategorias = getCategoriasDAO().getBeans();
	}
	
	@Override
	public void find() {
		try {
			if (codigo != 0)
				Categorias = getCategoriasDAO().getBean(codigo);
			else
				Categorias = new Categorias();
		} catch (Exception e) {
			showError("Erro ao tentar selecionar.");
		} finally {
			cleanMessageFlags();
		}
	}

	@Override
	public void list() {
		if (isNullOrEmpty(getCategorias().getNomeCategoria()) == false) {
			Categorias bean = new Categorias();
			bean.setNomeCategoria(getCategorias().getNomeCategoria());
			
			listCategorias = getCategoriasDAO().getBeansByExample(bean);
		} else {
			listCategorias = getCategoriasDAO().getBeans();
		}
	}

	@Override
	public void delete() {
		try {
			existDependences();
			if (isMessageError() == false) {
				getCategoriasDAO().excluir(Categorias);
				getCategoriasDAO().commit();
				showInfo("Dados excluidos com sucesso.");
			}
		} catch (Exception e) {
			getCategoriasDAO().rollback();
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
				getCategoriasDAO().atualizar(Categorias);
				getCategoriasDAO().commit();
				showInfo("Dados atualizados com sucesso.");
			}
		} catch (Exception e) {
			getCategoriasDAO().rollback();
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
				getCategoriasDAO().salvar(Categorias);
				getCategoriasDAO().commit();
				showInfo("Dados salvos com sucesso.");
			}

		} catch (Exception e) {
			getCategoriasDAO().rollback();
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
		if (isNullOrEmpty(getCategorias().getNomeCategoria()) == true)
			showAlert("Campo Nome é obrigatório");
	}

	@Override
	public void existDependences() {
		// TODO Auto-generated method stub

	}
}
