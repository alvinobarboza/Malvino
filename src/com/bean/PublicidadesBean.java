package com.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.dao.PublicidadesDAO;
import com.model.Publicidades;

@ManagedBean
@SessionScoped
public class PublicidadesBean extends BaseBean implements IBO, ICRUDBean {
	private Publicidades Publicidades;
	private PublicidadesDAO PublicidadesDAO;
	private List<Publicidades> listPublicidades;
	private int codigo;
	private String acao;// create, update, delete

	public Publicidades getPublicidades() {
		if (Publicidades == null)
			Publicidades = new Publicidades();
		return Publicidades;
	}

	public void setPublicidades(Publicidades Publicidades) {
		this.Publicidades = Publicidades;
	}

	public PublicidadesDAO getPublicidadesDAO() {
		if (PublicidadesDAO == null)
			PublicidadesDAO = new PublicidadesDAO();
		return PublicidadesDAO;
	}

	public void setPublicidadesDAO(PublicidadesDAO PublicidadesDAO) {
		this.PublicidadesDAO = PublicidadesDAO;
	}

	public List<Publicidades> getListPublicidades() {
		return listPublicidades;
	}

	public void setListPublicidades(List<Publicidades> listPublicidades) {
		this.listPublicidades = listPublicidades;
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
	
	public void listPublicidades(){
		listPublicidades = getPublicidadesDAO().getBeans();
	}
	
	@Override
	public void find() {
		try {
			if (codigo != 0)
				Publicidades = getPublicidadesDAO().getBean(codigo);
			else
				Publicidades = new Publicidades();
		} catch (Exception e) {
			showError("Erro ao tentar selecionar.");
		} finally {
			cleanMessageFlags();
		}
	}

	@Override
	public void list() {
		if (isNullOrEmpty(getPublicidades().getNome()) == false) {
			Publicidades bean = new Publicidades();
			bean.setNome(getPublicidades().getNome());
			
			listPublicidades = getPublicidadesDAO().getBeansByExample(bean);
		} else {
			listPublicidades = getPublicidadesDAO().getBeans();
		}
	}

	@Override
	public void delete() {
		try {
			existDependences();
			if (isMessageError() == false) {
				getPublicidadesDAO().excluir(Publicidades);
				getPublicidadesDAO().commit();
				showInfo("Dados excluidos com sucesso.");
			}
		} catch (Exception e) {
			getPublicidadesDAO().rollback();
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
				getPublicidadesDAO().atualizar(Publicidades);
				getPublicidadesDAO().commit();
				showInfo("Dados atualizados com sucesso.");
			}
		} catch (Exception e) {
			getPublicidadesDAO().rollback();
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
				getPublicidadesDAO().salvar(Publicidades);
				getPublicidadesDAO().commit();
				showInfo("Dados salvos com sucesso.");
			}

		} catch (Exception e) {
			getPublicidadesDAO().rollback();
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
		if (isNullOrEmpty(getPublicidades().getNome()) == true)
			showAlert("Campo Nome é obrigatório");
	
		if (isNullOrEmpty(getPublicidades().getDescricao()) == true)
			showAlert("Campo Descrição é obrigatório");
	}

	@Override
	public void existDependences() {
		// TODO Auto-generated method stub

	}
}
