package com.bean;

import java.sql.SQLException;
import java.util.List;

import com.dao.*;
import com.model.*;

public class MainTeste {
	
	
	public static void main(String [] args) throws SQLException {
		Jogos j = new Jogos();
		JogosDAO dao = new JogosDAO();
		
		j.setNome("v");
		
		List<Jogos> list = dao.getByName(j);
		
		for(Jogos item : list){
			System.out.println(item.getNome());
		}
		
			
	}
}
