package com.service;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bean.ClasBean;
import com.dao.ClasDAO;
import com.model.Clas;
import com.model.Perfis;



@Path("/ClasService") 
public class ClasService {
	
	private ClasBean bean;
	private ClasDAO ClasDAO;


	private ClasDAO getClasDAO() {
		if (ClasDAO == null)
			ClasDAO = new ClasDAO();
		return ClasDAO;
	}

	private void setClasDAO(ClasDAO ClasDAO) {
		this.ClasDAO = ClasDAO;
	}
	
	public ClasBean getBean() {
		if (bean == null)
			bean = new ClasBean();
		return bean;
	}

	public void setBean(ClasBean bean) {
		this.bean = bean;
	}
	
	@GET 
	@Path("/Clas") 
	@Produces(MediaType.APPLICATION_JSON)
	public Clas[] getClas() {
	
		List<Clas> Clas = getClasDAO().getBeans();

		Clas[] dtoList = new Clas[Clas.size()];

		int i = 0;

		for (Clas jogador : Clas){			
					
			dtoList[i] = getBean().cloneToDTO(jogador);
			
			i++;
		}

		return dtoList;
		
	}
	
	@GET 
	@Path("/Clas/{idJogador}") 
	@Produces(MediaType.APPLICATION_JSON)
	public Clas getJogador(@PathParam("idJogador") int codigo) {

		Clas cla = getClasDAO().getBean(codigo);

		return getBean().cloneToDTO(cla);
	}
	
	@POST
	@Path("/Salvar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvar(Clas Clas) {
		
		getClasDAO().salvar(Clas);
		getClasDAO().commit();
		
		return Response.ok().build();

	}
	
	@PUT
	@Path("/Atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Clas Clas) {
		
		getClasDAO().atualizar(Clas);
		getClasDAO().commit();
		
		return Response.ok().build();

	}
	
	@DELETE
	@Path("/Deletar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletar(Clas Clas) {
		
		getClasDAO().excluir(Clas);
		getClasDAO().commit();
		
		return Response.ok().build();

	}

}
