package com.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.dao.CategoriaPublicidadeDAO;
import com.dao.CategoriasDAO;
import com.dao.JogosCategoriaDAO;
import com.dao.JogosDAO;
import com.dao.PublicidadesDAO;
import com.model.CategoriaPublicidade;
import com.model.Categorias;
import com.model.Jogos;
import com.model.JogosCategoria;
import com.model.Publicidades;

@ManagedBean
@SessionScoped
public class CategoriasBean extends BaseBean implements IBO, ICRUDBean {
	private Jogos jogos;
	private JogosDAO jogosDAO; 
	private Categorias Categorias;
	private Publicidades publicidades;
	private CategoriasDAO CategoriasDAO;
	private JogosCategoria jogosCategoria;
	private PublicidadesDAO publicidadesDAO;
	private JogosCategoriaDAO cat_jogDAO;
	private CategoriaPublicidade categoriaPublicidade;
	private CategoriaPublicidadeDAO cat_pubDAO;
	private List<Categorias> listCategorias;
	private List<Jogos> listJogos;
	private List<Publicidades> listPublicidades;
	private List<JogosCategoria> listJogosCategorias;
	private List<CategoriaPublicidade> listCategoriaPublicidade;
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

	public List<Jogos> getListJogos() {
		listJogos = getJogosDAO().getBeans();
		return listJogos;
	}

	public void setListJogos(List<Jogos> listJogos) {
		this.listJogos = listJogos;
	}

	public List<Publicidades> getListPublicidades() {
		listPublicidades = getPublicidadesDAO().getBeans();
		return listPublicidades;
	}

	public void setListPublicidades(List<Publicidades> listPublicidades) {
		this.listPublicidades = listPublicidades;
	}

	public List<JogosCategoria> getListJogosCategorias() {
		listJogosCategorias = getCat_jogDAO().getBeans();
		return listJogosCategorias;
	}

	public void setListJogosCategorias(List<JogosCategoria> listJogosCategorias) {
		this.listJogosCategorias = listJogosCategorias;
	}

	public List<CategoriaPublicidade> getListCategoriaPublicidade() {
		listCategoriaPublicidade = getCat_pubDAO().getBeans();
		return listCategoriaPublicidade;
	}

	public void setListCategoriaPublicidade(List<CategoriaPublicidade> listCategoriaPublicidade) {
		this.listCategoriaPublicidade = listCategoriaPublicidade;
	}

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
	
	public CategoriaPublicidade getCategoriaPublicidade() {
		if(categoriaPublicidade == null)
			categoriaPublicidade = new CategoriaPublicidade();
		return categoriaPublicidade;
	}

	public void setCategoriaPublicidade(CategoriaPublicidade categoriaPublicidade) {
		this.categoriaPublicidade = categoriaPublicidade;
	}

	public CategoriaPublicidadeDAO getCat_pubDAO() {
		if(cat_pubDAO == null)
			cat_pubDAO = new CategoriaPublicidadeDAO();
		return cat_pubDAO;
	}

	public void setCat_pubDAO(CategoriaPublicidadeDAO cat_pubDAO) {
		this.cat_pubDAO = cat_pubDAO;
	}

	public JogosCategoria getJogosCategoria() {
		if(jogosCategoria == null)
			jogosCategoria = new JogosCategoria();
		return jogosCategoria;
	}

	public void setJogosCategoria(JogosCategoria jogosCategoria) {
		this.jogosCategoria = jogosCategoria;
	}

	public JogosCategoriaDAO getCat_jogDAO() {
		if(cat_jogDAO == null)
			cat_jogDAO = new JogosCategoriaDAO();
		return cat_jogDAO;
	}

	public void setCat_jogDAO(JogosCategoriaDAO cat_jogDAO) {
		this.cat_jogDAO = cat_jogDAO;
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
