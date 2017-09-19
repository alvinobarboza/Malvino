package com.bean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.dao.JogadoresDAO;
import com.model.Jogadores;


public class MainTeste {
	public static void main(String [] args) throws SQLException{
		
		Jogadores retorno = new Jogadores();
		JogadoresDAO dao = new JogadoresDAO();
		
		retorno.setLogin("Login errado");;
		
		String login = "alvino13";
		String senha = "1234";
		
		String sql = "select * from malvino.jogadores j "
				+ "where j.ds_login = '"+login+"' and j.ds_senha = '"+senha+"'";
		
		
		PreparedStatement ps = dao.getConnection().prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery() ;
		
		while(rs.next()){
			
				retorno.setLogin(rs.getString("ds_login"));
			
		}
	
		
		System.out.println(login);
		System.out.println(retorno.getLogin());
		
		
	
		
			System.out.println(retorno.getLogin());
	
		
	}
}
