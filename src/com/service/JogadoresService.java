package com.service;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bean.JogadoresBean;
import com.dao.JogadoresDAO;
import com.model.Jogadores;
import com.model.Perfis;



@Path("/JogadoresService") 
public class JogadoresService {
	
	private JogadoresBean bean;
	private JogadoresDAO jogadoresDAO;
	private Jogadores jogadores;
	private Perfis perfis;

	private JogadoresDAO getJogadoresDAO() {
		if (jogadoresDAO == null)
			jogadoresDAO = new JogadoresDAO();
		return jogadoresDAO;
	}

	private void setJogadoresDAO(JogadoresDAO jogadoresDAO) {
		this.jogadoresDAO = jogadoresDAO;
	}
	
	public JogadoresBean getBean() {
		if (bean == null)
			bean = new JogadoresBean();
		return bean;
	}

	public void setBean(JogadoresBean bean) {
		this.bean = bean;
	}
	
	@GET 
	@Path("/Jogadores") 
	@Produces(MediaType.APPLICATION_JSON)
	public Jogadores[] getJogadores() {
	
		List<Jogadores> jogadores = getJogadoresDAO().getBeans();

		Jogadores[] dtoList = new Jogadores[jogadores.size()];

		int i = 0;

		for (Jogadores jogador : jogadores){			
					
			dtoList[i] = getBean().cloneToDTO(jogador);
			
			i++;
		}

		return dtoList;
		
	}
	
	@GET 
	@Path("/Jogadores/{idJogador}") 
	@Produces(MediaType.APPLICATION_JSON)
	public Jogadores getJogador(@PathParam("idJogador") int codigo) {

		Jogadores jogador = getJogadoresDAO().getBean(codigo);

		return getBean().cloneToDTO(jogador);
		
	}
	
	@GET 
	@Path("/login") 
	@Produces(MediaType.APPLICATION_JSON)
	public Jogadores autenticar(@QueryParam("login") String login, @QueryParam("senha") String senha ) throws SQLException {

		return getBean().cloneToDTO(getJogadoresDAO().existOne(login, senha));
	
	}
	
	@POST
	@Path("/Salvar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvar(Jogadores jogadores) {
		
		getJogadoresDAO().salvar(jogadores);
		getJogadoresDAO().commit();
		
		return Response.ok().build();

	}

}
