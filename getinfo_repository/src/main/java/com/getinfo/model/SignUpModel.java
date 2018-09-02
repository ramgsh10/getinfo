package com.getinfo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class SignUpModel 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userId;
	private String name;
	private String emailorphone;
	private String password;
	@Lob
	private String file;
		
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
