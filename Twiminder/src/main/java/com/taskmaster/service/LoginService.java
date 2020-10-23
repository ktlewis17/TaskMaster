package com.taskmaster.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public interface LoginService {
	
        String getLogin(String phone, String password);

		String Login(String phone, String password);
        
		}
	  
	

