package com.compgoparts.datainitialization;

import java.io.Serializable;

/**
 * Unit test for simple App.
 */
public class DataInt implements Serializable
    
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8709856611068480301L;
	
	public String Email = "";
	
	public String Password = "";
	
	
    //----Login Getter and  Setters-------//		
	
	   public String getEmail() {
		   return Email;
		   
	   }
	   
	   public void setEmail(String email) {
		   Email = email;
	   }
	   
	   public String getPassword() {
		   return Password;
	   }
	   
	   public void setPassword(String password) {
		   Password = password;
	   }
	
    
}
