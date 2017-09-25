package com.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.dao.ClasDAO;
import com.model.Clas;
import com.model.Jogadores;

@ManagedBean
@SessionScoped
public class ClasBean extends BaseBean implements IBO, ICRUDBean {
	private Clas Clas;
	private ClasDAO ClasDAO;
	private List<Clas> listClas;
	private int codigo;
	private String acao;// create, update, delete

	public Clas getClas() {
		if (Clas == null)
			Clas = new Clas();
		return Clas;
	}

	public void setClas(Clas Clas) {
		this.Clas = Clas;
	}

	public ClasDAO getClasDAO() {
		if (ClasDAO == null)
			ClasDAO = new ClasDAO();
		return ClasDAO;
	}

	public void setClasDAO(ClasDAO ClasDAO) {
		this.ClasDAO = ClasDAO;
	}

	public List<Clas> getListClas() {
		return listClas;
	}

	public void setListClas(List<Clas> listClas) {
		this.listClas = listClas;
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
	
	public void listClas(){
		listClas = getClasDAO().getBeans();
	}
	
	@Override
	public void find() {
		try {
			if (codigo != 0)
				Clas = getClasDAO().getBean(codigo);
			else
				Clas = new Clas();
		} catch (Exception e) {
			showError("Erro ao tentar selecionar.");
		} finally {
			cleanMessageFlags();
		}
	}

	@Override
	public void list() {
		if (isNullOrEmpty(getClas().getNome()) == false) {
			Clas bean = new Clas();
			bean.setNome(getClas().getNome());
			
			listClas = getClasDAO().getBeansByExample(bean);
		} else {
			listClas = getClasDAO().getBeans();
		}
	}

	@Override
	public void delete() {
		try {
			existDependences();
			if (isMessageError() == false) {
				getClasDAO().excluir(Clas);
				getClasDAO().commit();
				showInfo("Dados excluidos com sucesso.");
			}
		} catch (Exception e) {
			getClasDAO().rollback();
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
				getClasDAO().atualizar(Clas);
				getClasDAO().commit();
				showInfo("Dados atualizados com sucesso.");
			}
		} catch (Exception e) {
			getClasDAO().rollback();
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
				getClasDAO().salvar(Clas);
				getClasDAO().commit();
				showInfo("Dados salvos com sucesso.");
			}

		} catch (Exception e) {
			getClasDAO().rollback();
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
		if (isNullOrEmpty(getClas().getNome()) == true)
			showAlert("Campo Nome é obrigatório");
	
		if (isNullOrEmpty(getClas().getDescricao()) == true)
			showAlert("Campo Descrição é obrigatório");
		
		if (getClas().getQtdMenbros() == 0)
			showAlert("Campo Quantidade é obrigatório");
		
		if (getClas().getQtdMenbros() < 3)
			showAlert("Campo Quantidade deve ser maior que 3");
		
		if (getClas().getQtdMenbros() > 50)
			showAlert("Campo Quantidade deve ser manor ou igual a 50");
		
	}

	@Override
	public void existDependences() {
		// TODO Auto-generated method stub

	}

	public Clas cloneToDTO(Clas bruto){
		
		Clas cla = new Clas();
		
		if(bruto==null){
			cla.setNome("Não Existe");
		}else{
		cla.setNome(bruto.getNome());
		cla.setDescricao(bruto.getDescricao());
		cla.setQtdMenbros(bruto.getQtdMenbros());
		cla.setIdCla(bruto.getIdCla());
		}
		return cla;
	}
}
