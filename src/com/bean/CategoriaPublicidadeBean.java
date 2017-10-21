package com.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.dao.CategoriasDAO;
import com.model.CategoriaPublicidade;
import com.model.Publicidades;
import com.model.Categorias;
import com.dao.CategoriaPublicidadeDAO;
import com.dao.PublicidadesDAO;

@ManagedBean
@SessionScoped
public class CategoriaPublicidadeBean extends BaseBean implements IBO, ICRUDBean {
	private Publicidades publicidades;
	private PublicidadesDAO publicidadesDAO;
	private Categorias Categorias;
	private CategoriasDAO CategoriasDAO;
	private CategoriaPublicidade categoriaPublicidade;
	private CategoriaPublicidadeDAO CategoriaPublicidadeDAO;
	private List<Publicidades> listPublicidades;
	private List<Categorias> listCategorias;
	private List<CategoriaPublicidade> listCategoriaPublicidades;
	private int codigo;
	private String acao;// create, update, delete
	
	
	
	
	public Publicidades getPublicidades() {
		if(publicidades == null)
			publicidades = new Publicidades();
		return publicidades;
	}

	public void setPublicidades(Publicidades publicidades) {
		this.publicidades = publicidades;
	}

	public PublicidadesDAO getPublicidadesDAO() {
		if(publicidadesDAO == null)
			publicidadesDAO = new PublicidadesDAO();
		return publicidadesDAO;
	}

	public void setPublicidadesDAO(PublicidadesDAO publicidadesDAO) {
		this.publicidadesDAO = publicidadesDAO;
	}

	public CategoriaPublicidade getCategoriaPublicidade() {
		if(categoriaPublicidade == null)
			categoriaPublicidade = new CategoriaPublicidade();
		return categoriaPublicidade;
	}

	public void setCategoriaPublicidade(CategoriaPublicidade categoriaPublicidade) {
		this.categoriaPublicidade = categoriaPublicidade;
	}

	public CategoriaPublicidadeDAO getCategoriaPublicidadeDAO() {
		if (CategoriaPublicidadeDAO == null)
			CategoriaPublicidadeDAO = new CategoriaPublicidadeDAO();
		return CategoriaPublicidadeDAO;
	}

	public void setCategoriaPublicidadeDAO(CategoriaPublicidadeDAO categoriaPublicidadeDAO) {
		CategoriaPublicidadeDAO = categoriaPublicidadeDAO;
	}

	
	public List<Publicidades> getListPublicidades() {
		return listPublicidades;
	}

	public void setListPublicidades(List<Publicidades> listPublicidades) {
		this.listPublicidades = listPublicidades;
	}

	public List<CategoriaPublicidade> getListCategoriaPublicidades() {
		return listCategoriaPublicidades;
	}

	public void setListCategoriaPublicidades(List<CategoriaPublicidade> listCategoriaPublicidades) {
		this.listCategoriaPublicidades = listCategoriaPublicidades;
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
	
	public void listCategoriaPublicidade(){
		listCategoriaPublicidades = getCategoriaPublicidadeDAO().getBeans();
	}
	public void listPublicidades(){
		listPublicidades = getPublicidadesDAO().getBeans();
	}
	public void listCategorias(){
		listCategorias = getCategoriasDAO().getBeans();
	}
	
	@Override
	public void find() {
		try {
			if (codigo != 0)
				categoriaPublicidade = getCategoriaPublicidadeDAO().getBean(codigo);
			else
				categoriaPublicidade = new CategoriaPublicidade();
		} catch (Exception e) {
			showError("Erro ao tentar selecionar.");
		} finally {
			cleanMessageFlags();
		}
	}

	@Override
	public void list() {
		if (isNullOrEmpty(getCategoriaPublicidade().getPublicidade().getNome()) == false) {
			CategoriaPublicidade bean = new CategoriaPublicidade();
			bean.getPublicidade().setNome(getCategoriaPublicidade().getPublicidade().getNome());
			
			listCategoriaPublicidades = getCategoriaPublicidadeDAO().getBeansByExample(bean);
		} else {
			listCategoriaPublicidades = getCategoriaPublicidadeDAO().getBeans();
		}
	}

	@Override
	public void delete() {
		try {
			existDependences();
			if (isMessageError() == false) {
				getCategoriaPublicidadeDAO().excluir(categoriaPublicidade);
				getCategoriaPublicidadeDAO().commit();
				showInfo("Dados excluidos com sucesso.");
			}
		} catch (Exception e) {
			getCategoriaPublicidadeDAO().rollback();
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
				getCategoriaPublicidadeDAO().atualizar(categoriaPublicidade);
				getCategoriaPublicidadeDAO().commit();
				showInfo("Dados atualizados com sucesso.");
			}
		} catch (Exception e) {
			getCategoriaPublicidadeDAO().rollback();
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
				getCategoriaPublicidadeDAO().salvar(categoriaPublicidade);
				getCategoriaPublicidadeDAO().commit();
				showInfo("Dados salvos com sucesso.");
			}

		} catch (Exception e) {
			getCategoriaPublicidadeDAO().rollback();
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
		if (isNullOrEmpty(getCategoriaPublicidade().getPublicidade().getNome()) == true)
			showAlert("Publicidade não foi selecionado");
		
		if (isNullOrEmpty(getCategoriaPublicidade().getCategoria().getNomeCategoria()) == true)
			showAlert("Categoria não foi selecionado");
	}

	@Override
	public void existDependences() {
		// TODO Auto-generated method stub

	}
}
