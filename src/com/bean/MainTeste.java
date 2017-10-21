package com.bean;

import java.util.List;

import com.model.CategoriaPublicidade;


public class MainTeste {
	public static void main(String [] args) {
		
		CategoriaPublicidadeBean teste = new CategoriaPublicidadeBean();
		//CategoriaPublicidadeDAO dao = new CategoriaPublicidadeDAO();
		
		List<CategoriaPublicidade> bean = teste.getListCategoriaPublicidades();
		//teste.getJogos().setIdJogo(1);
		
		/*try {
			teste = dao.getBeanID(2,2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		for(CategoriaPublicidade t : bean){
		System.out.println("publicidade "+t.getPublicidades().getNome()+" categoria "+t.getCategorias().getNomeCategoria());
		}
	}
}
