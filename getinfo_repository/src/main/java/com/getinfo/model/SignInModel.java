package com.getinfo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SignInModel  implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	@Id
	private String emailorphone;
	private String password;
	
	public String getEmailorphone() {
		return emailorphone;
	}
	public void setEmailorphone(String emailorphone) {
		this.emailorphone = emailorphone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
