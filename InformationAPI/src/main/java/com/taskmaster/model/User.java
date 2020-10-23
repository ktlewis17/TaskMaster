package com.taskmaster.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userdata")
public class User {
	@Id
	private String phone;
	
	@Column
	private String password;
	
	public User(){};
	public User(String phone, String password){
		this.phone = phone;
		this.password = password;
	}
	public String getPhoneNum() {
		return phone;
	}
	public void setPhoneNum(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
