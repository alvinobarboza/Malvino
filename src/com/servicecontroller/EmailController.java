package com.servicecontroller;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.mail.*;

import com.dao.JogadoresDAO;
import com.model.Jogadores;

@ManagedBean
@SessionScoped
public class EmailController {
	
	private String email;
	private JogadoresDAO dao;
	private Jogadores solicitante;
	
	

	public Jogadores getSolicitante() {
		if(solicitante == null)
			solicitante = new Jogadores();
		return solicitante;
	}

	public void setSolicitante(Jogadores solicitante) {
		this.solicitante = solicitante;
	}

	public JogadoresDAO getDao() {
		if(dao == null)
			dao = new JogadoresDAO();
		return dao;
	}

	public void setDao(JogadoresDAO dao) {
		this.dao = dao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String gerarSenha(){
		String[] carct ={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

	    String senha="";


	    for (int x=0; x<8; x++){
	        int j = (int) (Math.random()*carct.length);
	        senha += carct[j];
	    }
	    return senha;
	}
	
	@SuppressWarnings("deprecation")
	public boolean enviarEmail(String destino) throws SQLException{
		boolean validator = false;
		
		SimpleEmail email = new SimpleEmail();  
		
		setSolicitante(getDao().recuperarSenha(destino));
		
		if(getSolicitante().getEmail().equals(destino)){
			
			getSolicitante().setSenha(gerarSenha());
			getDao().atualizar(getSolicitante());
			getDao().commit();
			
			try {  
			      email.setDebug(true);  
			      email.setHostName("smtp.gmail.com");  
			      email.setSmtpPort(465);
			      email.setSSL(true);
			      email.setAuthenticator(new DefaultAuthenticator("malvinoteste@gmail.com","Malvinogamesuite1"));  
			      email.addTo(destino); //pode ser qualquer email  
			      email.setFrom("malvinoTeste@gmail.com"); //será passado o email que você fará a autenticação 
			      email.setSubject("Recuperação de senha");  
			      email.setMsg("Olá, "+getSolicitante().getNome()+" \n Sua nova senha é: "+getSolicitante().getSenha());  
			      email.send(); 
			      
			      validator = true;
	
			} catch (EmailException e) {  
	
				System.out.println(e.getMessage());
			}
		}
		return validator;
	}
}
