package com.bean;

import java.sql.SQLException;
import java.util.List;

import com.dao.ClasDAO;
import com.dao.JogadoresDAO;
import com.dao.PerfisDAO;
import com.model.Clas;
import com.model.Jogadores;
import com.model.Perfis;

public class MainTeste {
	public static void main(String [] args) throws SQLException{
		
		JogadoresDAO dao = new JogadoresDAO();
		Jogadores jogadores = new Jogadores();
		PerfisDAO perfisDAO = new PerfisDAO();
		Perfis perfis = new Perfis();
		ClasDAO clasDAO = new ClasDAO();
		Clas clas = new Clas();
		
		clas = clasDAO.getBean(1);
		perfis = perfisDAO.getBean(2);
		
	/*	jogadores.setNome("Jose");
		jogadores.setEmail("jose@email.com");
		jogadores.setLogin("naovalenadatbm");
		jogadores.setSenha("1234");
		jogadores.setGenero("M");
		jogadores.setPerfis(perfis);
		jogadores.setCla(clas);
		
		dao.salvar(jogadores);
		dao.commit();
		*/
		
		List<Jogadores> lista = dao.getBeans();
		
		for(Jogadores teste : lista){
			System.out.println("id = "+ teste.getIdJogador()+
					"Nome: " + teste.getNome() + "\n"
					+"Clã: "+teste.getClas().getNome()+"\n"
					+"Perfil: "+teste.getPerfis().getNome()+"\n\n"
					+"teste: "+teste.getPerfis().getDescricao());
		}
		
	}
}
