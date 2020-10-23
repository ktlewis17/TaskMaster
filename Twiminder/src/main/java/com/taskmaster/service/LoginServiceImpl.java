package com.taskmaster.service;
import org.springframework.beans.factory.annotation.Autowired;

import com.taskmaster.repository.LoginRepository;
//import com.taskmaster.repository.UserRepository;
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginRepository lr;

	@Override
	public String Login(String phone, String password) {
		// TODO Auto-generated method stub
		return Login("","");
	}

	@Override
	public String getLogin(String phone, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
	
