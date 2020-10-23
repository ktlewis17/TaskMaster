package com.taskmaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmaster.model.User;
import com.taskmaster.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository ur;
	
	@Override
	public boolean validateUser(String pn, String pw) {
		User x = ur.findById(pn).get();
		if(x != null && x.getPassword().equals(pw)) {
			return true;
		}
		return false;
	}
	
	public String addUser(String pn, String pw) {
		User x = new User(pn, pw);
		ur.save(x);
		return "User Added";
		
	}
	
	public String deleteUserByPhone(String pn) {
		ur.deleteById(pn);
		return "User Deleted";
	}
	
	public String editUserPassword(String pn, String newPw) {
		User x = ur.findById(pn).get();
		x.setPassword(newPw);
		ur.save(x);
		return "Users Password was Updated";
	}
	
	
}
