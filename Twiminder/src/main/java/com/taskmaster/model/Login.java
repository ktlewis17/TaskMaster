package com.taskmaster.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
@Table(name="logindata")
public class Login {
      @Column
	  private String phone;
      
      @Column
	  	private String password;
      
      public Login(String phone, String password) {
    	  super();
    	  this.phone = phone;
    	  this.password = password;
      }
       public Login() {
    	   super();
    	  
      }
	  	
	  public String getPhone() {
	    return phone;
	  }

	  public void setPhone(String phone) {
	    this.phone = phone;
	  }

	  public String getPassword() {
	    return password;
	  }

	  public void setPassword(String password) {
	    this.password = password;
	  }

	}

