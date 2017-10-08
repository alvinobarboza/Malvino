package com.bean;

import java.sql.SQLException;

import com.dao.PerfisDAO;
import com.model.Perfis;


public class MainTeste {
	public static void main(String [] args) throws SQLException{
		
		Perfis teste = new Perfis();
		PerfisDAO dao = new PerfisDAO();
		
		teste = dao.getBean(1);
		
		System.out.println(teste.getNome());
		
	}
}
