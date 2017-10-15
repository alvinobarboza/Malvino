package com.bean;

import java.util.List;

import com.dao.JogadoresDAO;
import com.model.Jogadores;


public class MainTeste {
	public static void main(String [] args) {
		
		//Jogadores teste = new Jogadores();
		JogadoresDAO dao = new JogadoresDAO();
		
		List<Jogadores> teste = dao.getBeans();
		
		
		for(Jogadores t : teste){
		System.out.println(t.getNome());
		}
	}
}
