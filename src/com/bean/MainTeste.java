package com.bean;


import java.sql.SQLException;



public class MainTeste {
	public static void main(String [] args) throws SQLException {
		String[] carct ={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

	    String senha="";


	    for (int x=0; x<10; x++){
	        int j = (int) (Math.random()*carct.length);
	        senha += carct[j];
	    }
	    
	    System.out.println(senha);
			
	}
}
