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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dao.JogadoresDAO;
import com.model.Jogadores;
import com.servicecontroller.JogadoresController;
import com.servicecontroller.Logar;



@Path("/JogadoresService") 
public class JogadoresService {
	
	private JogadoresController controller;

	private JogadoresDAO jogadoresDAO;

	public JogadoresController getController() {
		if(controller == null)
			controller=new JogadoresController();
		return controller;
	}
	
	
	public void setController(JogadoresController controller) {
		this.controller = controller;
	}
	private JogadoresDAO getJogadoresDAO() {
		if (jogadoresDAO == null)
			jogadoresDAO = new JogadoresDAO();
		return jogadoresDAO;
	}

	
	@GET 
	@Path("/Jogadores") 
	@Produces(MediaType.APPLICATION_JSON)
	public Jogadores[] getJogadores() {
	
		List<Jogadores> jogadores = getJogadoresDAO().getBeans();

		Jogadores[] dtoList = new Jogadores[jogadores.size()];

		int i = 0;

		for (Jogadores jogador : jogadores){			
					
			dtoList[i] = getController().cloneToDTO(jogador);
			
			i++;
		}

		return dtoList;
		
	}
	
	@GET 
	@Path("/Jogadores/{idJogador}") 
	@Produces(MediaType.APPLICATION_JSON)
	public Jogadores getJogador(@PathParam("idJogador") int codigo) {

		Jogadores jogador = getJogadoresDAO().getBean(codigo);

		return getController().cloneToDTO(jogador);
		
	}
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response autenticar(Logar logar) throws SQLException {
				
		
		if(getJogadoresDAO().login(logar.getLogin(),logar.getSenha())){
			return Response.ok().entity(logar).build();
		}else{	
			logar.setLogin(logar.getLogin()+" Usuário não encontrado");
			return Response.status(400).entity(logar).build();
		}
	
	}
	
	@POST
	@Path("/Salvar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvar(Jogadores jogadores) {
		
		Logar teste = getController().verificaDuplicado(jogadores);
		
		if(teste.getLogin().equals("ok")&&teste.getSenha().equals("ok")){
			
			getJogadoresDAO().salvar(jogadores);
			getJogadoresDAO().commit();
			return Response.ok().entity("ok").build();
			
		}else{	
			return Response.status(400).entity(teste).build();
		}
	}
	
	@PUT
	@Path("/Atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Jogadores jogadores) {
		
		getJogadoresDAO().atualizar(jogadores);
		getJogadoresDAO().commit();
		
		return Response.ok().build();

	}
	
	@DELETE
	@Path("/Deletar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletar(Jogadores jogadores) {
		
		//Jogadores jogadores = new Jogadores();
		
		//jogadores = getJogadoresDAO().getBean(codigo);
		
		getJogadoresDAO().excluir(jogadores);
		getJogadoresDAO().commit();
		
		return Response.status(200, "Deletado com sucesso").build();

	}

}
